package pl.kozakowski.statisticfilestools;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSelector {

    private String pathDirectory;
    private Results results;
    private Boolean noSaveResultToMasterCopy;

    public FileSelector(String[] arqs) throws IOException, ClassNotFoundException {
        noSaveResultToMasterCopy = false;
        if(arqs.length == 1) this.pathDirectory = arqs[0];
        if(arqs.length == 2) {
            this.pathDirectory = arqs[0];
            if(arqs[1].contains("1")) {
                noSaveResultToMasterCopy = true;
            }
        }
        recoverResultsClass();
        if(!Paths.get(pathDirectory).toFile().isDirectory()) throw new IOException("Path is not Directory");
        results.addNewDate();
        System.out.println("End of FileSelector Constructor");
    }

    public void walk(String pathDirectory) throws IOException {
        Files.walk(Paths.get(pathDirectory))
                .filter(path -> path.toFile().isFile())
                .filter(path -> !path.toString().contains(".git"))
                .filter(path -> !path.toString().contains(".idea"))
                .filter(path -> !path.toString().contains(".target"))
                .filter(path -> !path.toString().contains(".class"))
                .filter(path -> !path.toString().contains(".cache"))
                .filter(path -> !path.toString().contains("node_modules"))
                .forEach(path -> {
                    try {
                        visit(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        results.saveToCSV();
        results.saveToXLSX();
    }

    private void visit(Path path) throws IOException {
        String temp;
        if(path.toString().endsWith("\\")) temp = path.toString().replace(pathDirectory, "");
        else temp = path.toString().replace(pathDirectory+"\\","");
        Long countedLines = 0L;
//        if(path.endsWith(".docx")) {
//            countedLines = countLinesInDocX(path);
//        } else {
            countedLines = countLines(path);
//        }
        results.addRow(temp, countedLines);
    }

//    private Long countLinesInDocX(Path path) {
//
//    }

    private long countLines(Path path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path.toString()));
        int linesCount = 0;
        while (reader.readLine() != null) linesCount++;
        reader.close();
        return linesCount;
    }

    private void recoverResultsClass() throws IOException, ClassNotFoundException {
        if(Files.exists(Paths.get("historyResults.dk"))) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("historyResults.dk"));
            results = (Results) in.readObject();
        } else {
            results = new Results();
        }
    }

    public void saveMasterCopy() throws IOException {
        if(noSaveResultToMasterCopy == false) {
            System.out.println("Zapisuje kopie danych do historii");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("historyResults.dk"));
            out.writeObject(results);
            out.close();
        } else {
            System.out.println("Nie zapisuję kopii danych do historii");
        }

    }
}
