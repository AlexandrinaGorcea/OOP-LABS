package DocumentManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeDocument extends Document {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public CodeDocument(String name) {
        super(name);
    }

    private void parseCodeFile() {
        Path filePath = Paths.get(Constants.folderPath, getName());
        String fileName = filePath.getFileName().toString();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                Pattern classPattern, methodPattern;
                Matcher classMatcher, methodMatcher;
                if (extension.equals("py")) {
                    classPattern = Pattern.compile("^class\\s+\\w+(\\(.*\\))?:");
                    methodPattern = Pattern.compile("^def\\s+\\w+\\(.*\\):");
                } else if (extension.equals("java")) {
                    classPattern = Pattern.compile("\\bclass\\b");
                    methodPattern = Pattern.compile("^(public|private|protected|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+[\\w_]+\\(.*\\)\\s*\\{?$");
                } else {
                    continue;
                }
                classMatcher = classPattern.matcher(line.trim());
                methodMatcher = methodPattern.matcher(line.trim());
                if (classMatcher.find())
                    classCount++;
                if (methodMatcher.find())
                    methodCount++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + getName());
            System.exit(1);
        }
    }

    @Override
    public void printInfo() {
        parseCodeFile();
        System.out.println("Program File: " + getName());
        System.out.println("Line Count: " + lineCount);
        System.out.println("Class Count: " + classCount);
        System.out.println("Method Count: " + methodCount);
    }
}