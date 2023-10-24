package FileTypes;

public abstract class File {
    protected String fileName;
    protected String fileExtension;
    protected Date createdDate;
    protected Date updatedDate;

    public File(String fileName, String fileExtension, Date createdDate, Date updatedDate) {
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public abstract void printInfo();
}
