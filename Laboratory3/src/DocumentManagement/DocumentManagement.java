package DocumentManagement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentManagement {
    private final ArrayList<DocumentManagement> documents = new ArrayList<>();
    private long lastSnapshotTime = loadLastSnapshotTime();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void displayLastSnapshotTime() {
        System.out.println("Last saved snapshot time: " + dateFormat.format(lastSnapshotTime));
    }

    public void commit() {
        lastSnapshotTime = System.currentTimeMillis();
        saveLastSnapshotTime();
        System.out.println("Snapshot time updated to: " + dateFormat.format(new Date(lastSnapshotTime)));
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

    private long loadLastSnapshotTime() {
        try {
            File file = new File("Laboratory3/last_snapshot_time.txt");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (line != null) {
                    return Long.parseLong(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void saveLastSnapshotTime() {
        try {
            File file = new File("Laboratory3/last_snapshot_time.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            long currentTime = System.currentTimeMillis();
            writer.write(Long.toString(currentTime));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info(String filename) {
        Path filePath = Paths.get("Laboratory3/Files", filename);
        if (Files.exists(filePath)) {
            try {
                BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
                System.out.println("File Name: " + filePath.getFileName());
                System.out.println("Created: " + dateFormat.format(new Date(attributes.creationTime().toMillis())));
                System.out.println("Last Modified: " + dateFormat.format(new Date(attributes.lastModifiedTime().toMillis())));

                if (filename.endsWith(".txt")) {
                    // Display text file information
                    displayTextFileInfo(filePath);
                } else if (filename.endsWith(".img") || filename.endsWith(".jpg")) {
                    // Display image file information
                    displayImageFileInfo(filePath);
                } else if (filename.endsWith(".py") || filename.endsWith(".java")) {
                    // Display Python or Java file information
                    displayCodeFileInfo(filePath);
                } else {
                    System.out.println("File type not supported for additional information.");
                }
            } catch (IOException e) {
                System.out.println("Error accessing file information: " + e.getMessage());
            }
        } else {
            System.out.println("File not found: " + filename);
        }
    }

    private void displayTextFileInfo(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            int lineCount = lines.size();
            int charCount = 0;
            int wordCount = 0;

            for (String line : lines) {
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Line Count: " + lineCount);
            System.out.println("Character Count: " + charCount);
            System.out.println("Word Count: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayImageFileInfo(Path filePath) {
        try {
            BufferedImage image = ImageIO.read(filePath.toFile());
            int width = image.getWidth();
            int height = image.getHeight();
            System.out.println("Image Size: " + width + "x" + height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayCodeFileInfo(Path filePath) {
        int methodCount = countMethods(filePath);
        System.out.println("Method Count: " + methodCount);
    }

    private int countMethods(Path filePath) {
        int methodCount = 0;
        boolean insideMethod = false;
        String fileName = filePath.getFileName().toString();
        Pattern methodPattern;

        if (fileName.endsWith(".java")) {
            // Java method pattern
            methodPattern = Pattern.compile(".*(\\b(public|private|protected)\\b)?.*\\bvoid\\s+(\\w+)\\s*\\(.*");
        } else if (fileName.endsWith(".py")) {
            // Python method pattern
            methodPattern = Pattern.compile("def\\s+(\\w+)\\(.*\\):");
        } else {
            return 0; // Unsupported file type
        }

        try {
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                if (!insideMethod) {
                    Matcher matcher = methodPattern.matcher(line);
                    if (matcher.matches()) {
                        methodCount++;
                        insideMethod = true;
                    }
                } else if (line.trim().isEmpty()) {
                    insideMethod = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return methodCount;
    }

}
