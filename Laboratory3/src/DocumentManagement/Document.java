package DocumentManagement;

import FileTypes.*;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;

public class Document {
    private final ArrayList<FFile> documents = new ArrayList<>();
    private long lastSnapshotTime = System.currentTimeMillis();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void commit() {
        lastSnapshotTime = System.currentTimeMillis();
        System.out.println("Snapshot time updated to: " + dateFormat.format(lastSnapshotTime));
    }

    public void status(String rootFolderPath) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Path rootPath = Paths.get(rootFolderPath);
        Files.walkFileTree(rootPath, options, Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                String relativePath = rootPath.relativize(file).toString();
                long lastModifiedTime = attrs.lastModifiedTime().toMillis();
                if (lastModifiedTime > lastSnapshotTime) {
                    System.out.println(relativePath + " - Changed (on " + dateFormat.format(new Date(lastModifiedTime)) + ")");
                } else {
                    System.out.println(relativePath + " - No Change");
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void info(String filename) {
        for (FFile file : documents) {
            if (file.getFileName().equals(filename)) {
                file.printInfo();
                return;
            }
        }
        System.out.println("File not found: " + filename);
    }

    public void addFile(FFile file) {
        documents.add(file);
    }
}