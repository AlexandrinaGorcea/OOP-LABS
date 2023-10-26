package FileTypes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageFile extends File {
    private int width;
    private int height;

    public ImageFile(String directoryPath, String fileName, long updatedDate) {
        super(directoryPath, fileName, updatedDate);
        fetchImageSize();
    }

    private void fetchImageSize() {
        java.io.File file = new java.io.File(super.directoryPath + java.io.File.separator + super.fileName);
        try{
            BufferedImage image = ImageIO.read(file);
            width = image.getWidth();
            height = image.getHeight();
        } catch (IOException e){
            e.printStackTrace();
            width = -1;
            height = -1;
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Image size: " + width + "x" + height);
    }
}