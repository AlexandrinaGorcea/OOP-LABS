package FileTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProgramFile extends FFile {
    private int lineCount;
    private int classCount;
    private int methodCount;

    public ProgramFile(String directoryPath, String fileName, long updatedDate) {
        super(directoryPath, fileName, updatedDate);
        parseProgramFile();
    }

    private void parseProgramFile() {
        java.io.File file = new java.io.File(super.directoryPath + java.io.File.separator + super.fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;

                Matcher classMatcher, methodMatcher;
                Pattern classPattern, methodPattern;

                if (super.extension.equals("py")) {
                    classPattern = Pattern.compile("^class\\s+\\w+:");
                    methodPattern = Pattern.compile("^def\\s+\\w+\\(.*\\):");
                } else if (super.extension.equals("java")) {
                    classPattern = Pattern.compile("\\bclass\\b");
                    methodPattern = Pattern.compile("^(public|private|protected|static|\\s) + [\\w\\<\\>\\[\\]]+\\s+[\\w_]+\\(.*\\)\\s*\\{?$");
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
            e.printStackTrace();
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Line count: " + lineCount);
        System.out.println("Class count: " + classCount);
        System.out.println("Method count: " + methodCount);
    }
}