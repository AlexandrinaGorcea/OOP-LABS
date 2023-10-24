package FileFactory;

public class FileFactory {
    public File createFile(String fileName, String fileExtension, Date createdDate, Date updatedDate) {
        switch (fileExtension) {
            case "png":
            case "jpg":
                // Create and return an ImageFile object
            case "txt":
                // Create and return a TextFile object
            case "py":
            case "java":
                // Create and return a ProgramFile object
            default:
                // Handle unknown file types
        }
    }
}
