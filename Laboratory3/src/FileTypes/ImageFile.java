package FileTypes;

public class ImageFile extends File {
    private String imageSize;

    public ImageFile(String fileName, String fileExtension, Date createdDate, Date updatedDate, String imageSize) {
        super(fileName, fileExtension, createdDate, updatedDate);
        this.imageSize = imageSize;
    }

    @Override
    public void printInfo() {
        // Implement print logic here
    }
}