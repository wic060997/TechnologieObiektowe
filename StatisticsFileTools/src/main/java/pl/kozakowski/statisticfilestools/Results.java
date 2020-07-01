package pl.kozakowski.statisticfilestools;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Results implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fileNameCSVHeader = "Nazwa Pliku";
    private LinkedList<String> datesCSVHeader;
    private Map<String, ArrayList<Long>> results;
    private Integer size;

    public Results() {
        datesCSVHeader = new LinkedList<>();
        results = new TreeMap<>();
        this.size = datesCSVHeader.size();
    }

    public int size() {
        return size;
    }

    public int addNewDate() {

        // add new header with current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm");
        LocalDateTime today = LocalDateTime.now();
        datesCSVHeader.add(formatter.format(today));
        size = datesCSVHeader.size();

        // init by NULL value of lines in all files
        results.forEach((name, amountsOfLines) -> amountsOfLines.add(null));

//        System.out.println("Dodano nowy naglowek");
        return size;
    }

    public void addRow(String fileName, Long linesAmount) {
        ArrayList<Long> result = results.get(fileName);
        if(result == null) {
            result = new ArrayList<Long>();
            for (int i = 0; i < size ; i++) {
                result.add(null);
            }
            result.set(size-1,linesAmount);
        } else {
            result.set(result.size()-1, linesAmount);
        }
        results.put(fileName, result);
    }

    public void saveToXLSX() {
        String resultsFileName = "results_" + (datesCSVHeader.getLast()).replace(":", "_");
        resultsFileName += ".xlsx";
        resultsFileName = resultsFileName.replace(" ", "_");

        Workbook wb = new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("Raport_TO");
        AtomicReference<Row> row = new AtomicReference<>(sheet1.createRow(0));
        row.get().createCell(0).setCellValue(fileNameCSVHeader);
        AtomicInteger cellNumber = new AtomicInteger(1);
        for (String date : datesCSVHeader) {
            row.get().createCell(cellNumber.get()).setCellValue(date);
            cellNumber.getAndIncrement();
        }
        AtomicInteger rowNumber = new AtomicInteger(1);
        cellNumber.set(1);
        results.forEach((s, longs) -> {
            row.set(sheet1.createRow(rowNumber.get()));
            row.get().createCell(0).setCellValue(s);
            cellNumber.set(1);
            longs.forEach(aLong -> {
                if(aLong == null) row.get().createCell(cellNumber.get()).setCellValue("");
                else row.get().createCell(cellNumber.get()).setCellValue(aLong);
                cellNumber.getAndIncrement();
            });
            rowNumber.getAndIncrement();
        });
//        sheet1.autoSizeColumn(0);
        for (int i = 0; i < datesCSVHeader.size()+1; i++) {
            sheet1.autoSizeColumn(i);
        }

        cellNumber.set(1);
        rowNumber.getAndIncrement();
        row.set(sheet1.createRow(rowNumber.get()));
        Row row1 = sheet1.createRow(rowNumber.incrementAndGet());
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.RIGHT);
        row.get().createCell(0).setCellValue("Liczba lini:");
        row1.createCell(0).setCellValue("Liczba plików:");

        row.get().getCell(0).setCellStyle(cellStyle);
        row1.getCell(0).setCellStyle(cellStyle);

        // get first row cell adress
        datesCSVHeader.size();
        ArrayList<CellRangeAddress> cellRangeAddresses = new ArrayList<>();
        for (int i = 1; i < datesCSVHeader.size()+1; i++) {
            cellRangeAddresses.add(new CellRangeAddress(1, results.size(), i, i));
        }

        for (int i = 1; i < datesCSVHeader.size()+1; i++) {
            row.get().createCell(i, CellType.FORMULA).setCellFormula("sum(" + cellRangeAddresses.get(i-1).formatAsString() + ")");
            row1.createCell(i, CellType.FORMULA).setCellFormula(
                    "rows(" + cellRangeAddresses.get(i-1).formatAsString() + ")" +
                    "-countblank(" + cellRangeAddresses.get(i-1).formatAsString() + ")"
            );
        }

//        row.get().createCell(cellNumber.get(), CellType.FORMULA).setCellFormula("sum("+cellRangeAddresses.get(0).formatAsString()+")");
        cellNumber.getAndIncrement();

        try (OutputStream fileOut = new FileOutputStream(resultsFileName)) {
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void saveToCSV() throws IOException {
        String resultsFileName = "results_" + (datesCSVHeader.getLast()).replace(":", "_");
        resultsFileName += ".csv";
        resultsFileName.replace(" ", "_");
//        resultsFileName.replace(":", "_");
        System.out.println(resultsFileName);
        FileWriter save = new FileWriter(resultsFileName);
        String temp;
        String temp2;
        temp = "\""+fileNameCSVHeader+"\"";
        for (String s : datesCSVHeader) {
            temp2 = s.toString();
            temp2 = temp2.replace("[","");
            temp2 = temp2.replace("]","");
            temp = temp + "," + temp2;
//            System.out.println("Naglowek: "+temp);
        }
        save.write(temp+"\n");
        for (Map.Entry<String,ArrayList<Long>> entry : results.entrySet()) {
            temp = "\""+entry.getKey()+"\"";
            for (Long amount : entry.getValue()) {
                if(amount == null) temp += ",";
                else temp += ","+amount.toString();
            }
            System.out.println(temp);
            save.write(temp+"\n");
        }
        save.close();
    }
}
