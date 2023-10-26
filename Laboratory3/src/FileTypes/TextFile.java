package FileTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFile extends File {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextFile(String directoryPath, String fileName, long updatedDate) {
        super(directoryPath, fileName, updatedDate);
        if(this.updatedDate != 0)
            computeTextFileAttributes();
    }

    private void computeTextFileAttributes(){
        java.io.File file = new java.io.File(super.directoryPath + java.io.File.separator + super.fileName);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
    }
}