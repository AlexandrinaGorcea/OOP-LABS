package DocumentManagement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageDocument extends Document {
    private int width;
    private int height;

    public ImageDocument(String name) {
        super(name);
    }

    @Override
    public void printInfo() {
        System.out.println("Image File: " + getName());

        // Import the folderPath from Constants.java and append the filename
        Path filePath = Paths.get(Constants.folderPath, getName());

        // Call the method with the result
        displayImageFileInfo(filePath);

        System.out.println("Image Size: " + width + "x" + height);
    }

    private void displayImageFileInfo(Path filePath) {
        try {
            BufferedImage image = ImageIO.read(filePath.toFile());
            width = image.getWidth();
            height = image.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
