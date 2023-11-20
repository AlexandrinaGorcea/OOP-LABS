package DocumentManagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextDocument extends Document {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextDocument(String name) {
        super(name);
    }

    @Override
    public void printInfo() {
        System.out.println("Text File: " + getName());

        // Import the folderPath from Constants.java and append the filename
        Path filePath = Paths.get(Constants.folderPath, getName());

        // Call the method with the result
        displayTextFileInfo(filePath);

        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
    }

    private void displayTextFileInfo(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            lineCount = lines.size();
            charCount = 0;
            wordCount = 0;

            for (String line : lines) {
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}