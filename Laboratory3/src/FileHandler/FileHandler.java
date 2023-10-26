package FileHandler;

import java.util.HashMap;
import java.util.Map;
import FileTypes.FFile;

public class FileHandler {
    private Map<String, FFile> files;
    private long lastSnapshotTime;

    public FileHandler() {
        this.files = new HashMap<>();
        this.lastSnapshotTime = System.currentTimeMillis();
    }

    public FFile getFile(String filename) {
        return this.files.get(filename);
    }

    public void checkForChanges() {
        for (FFile file : this.files.values()) {
            if (file.getUpdatedDate() > this.lastSnapshotTime) {
                System.out.println(file.getFileName() + " - Changed");
            } else {
                System.out.println(file.getFileName() + " - No Change");
            }
        }
    }

    public void addFile(FFile file) {
        this.files.put(file.getFileName(), file);
    }

    public void removeFile(String filename) {
        this.files.remove(filename);
    }

    public void updateSnapshotTime() {
        this.lastSnapshotTime = System.currentTimeMillis();
    }
}