package FileTypes;

public class TextFile extends File {
    private int lineCount;
    private int wordCount;
    private int charCount;

    public TextFile(String fileName, String fileExtension, Date createdDate, Date updatedDate, int lineCount, int wordCount, int charCount) {
        super(fileName, fileExtension, createdDate, updatedDate);
        this.lineCount = lineCount;
        this.wordCount = wordCount;
        this.charCount = charCount;
    }

    @Override
    public void printInfo() {
        // Implement print logic here
    }
}