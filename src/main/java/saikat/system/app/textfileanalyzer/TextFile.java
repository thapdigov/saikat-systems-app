package saikat.system.app.textfileanalyzer;

import java.io.Serializable;

public class TextFile implements Serializable {
    private final String content;

    public TextFile(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void analyze() {
        String[] lines = content.split("\n");
        int lineCount = lines.length;
        int wordCount = 0;
        int charCount = content.length();

        for (String line : lines) {
            wordCount += line.split("\\s+").length;
        }
        System.out.println("Number of lines: " + lineCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of characters: " + charCount);
    }
}
