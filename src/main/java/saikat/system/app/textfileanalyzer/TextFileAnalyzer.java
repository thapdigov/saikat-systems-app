package saikat.system.app.textfileanalyzer;

import java.io.*;

public class TextFileAnalyzer {

    public void textFileAnalyzer() {
        String filePath = "textAnalyzer.dat";

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            TextFile analyzer = (TextFile) ois.readObject();
            System.out.println("Text read from the file: ");
            System.out.println(analyzer.getContent());
            analyzer.analyze();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while reading the object from the file: " + e.getMessage());
        }
    }
}
