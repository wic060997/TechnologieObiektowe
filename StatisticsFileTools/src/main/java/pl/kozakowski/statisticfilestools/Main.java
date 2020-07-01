package pl.kozakowski.statisticfilestools;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if(args.length < 1) return;
        FileSelector fileSelector = new FileSelector(args);
        fileSelector.walk(args[0]);
        fileSelector.saveMasterCopy();
        return;
    }

}
