package FileTypes;

public class ProgramFile extends File {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public ProgramFile(String fileName, String fileExtension, Date createdDate, Date updatedDate, int lineCount, int classCount, int methodCount) {
        super(fileName, fileExtension, createdDate, updatedDate);
        this.lineCount = lineCount;
        this.classCount = classCount;
        this.methodCount = methodCount;
    }

    @Override
    public void printInfo() {
        // Implement print logic here
    }
}