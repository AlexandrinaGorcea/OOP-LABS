package FileTypes;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import date.FormatOfTheTime;



public class FFile {
    protected String directoryPath;
    protected String fileName;
    protected String extension;
    protected long createdDate;
    protected long updatedDate;

    public FFile(String directoryPath, String fileName, long updatedDate) {
        this.fileName = fileName;
        this.extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        this.directoryPath = directoryPath;
        this.updatedDate = updatedDate;
        if (this.updatedDate != 0)
            setFileTimes();
    }

    public long getUpdatedDate(){
        return updatedDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileTimes(){
        Path filePath = Paths.get(directoryPath, fileName);
        try{
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            this.createdDate = attrs.creationTime().toMillis();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printInfo(){
        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
        System.out.println("File Name: " + fileNameWithoutExtension);
        System.out.println("Extension: " + extension);
        System.out.println("Created time: " + FormatOfTheTime.formatTimestamp(this.createdDate));
        System.out.println("Last modified time: " + FormatOfTheTime.formatTimestamp(this.updatedDate));
    }

    public static FFile createFile(String path, String fileName, long updatedDate){
        String extension = getExtensionOfTheFile(fileName);
        switch (extension){
            case "png":
            case "jpg":
                return new ImageFile(path, fileName, updatedDate);
            case "txt":
                return new TextFile(path, fileName, updatedDate);
            case "java":
            case "py":
                return new CodeFile(path, fileName, updatedDate);
            default:
                return new FFile(path, fileName, updatedDate);
        }
    }

    public static String getExtensionOfTheFile(String fileName){
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex > 0 && lastIndex < fileName.length() - 1){
            return fileName.substring(lastIndex + 1).toLowerCase();
        }
        return "";
    }
}