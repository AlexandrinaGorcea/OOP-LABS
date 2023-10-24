package FileManagement;

import java.io.*;
import java.util.*;

public class FileHandler {
    private FileFactory fileFactory;
    private List<File> files;

    public FileHandler() {
        this.fileFactory = new FileFactory();
        this.files = new ArrayList<>();
    }

    public void loadFilesFromDirectory(String directoryPath) {
        // Use java.io.File to get a list of all files in the directory
        // For each file, use the FileFactory to create a File object
        // Add the File object to the files list
    }

    public File getFile(String fileName) {
        // Search the files list for a file with the given name
        // Return the File object, or null if no such file is found
    }

    public void checkForChanges() {
        // For each File object in the files list, check if the file has changed since the last snapshot
        // If a file has changed, update the File object and print a message to the console
    }
}