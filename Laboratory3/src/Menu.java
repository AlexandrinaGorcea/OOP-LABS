import java.io.IOException;
import java.util.Scanner;
import FileHandler.FileHandler;
import FileTypes.FFile;

public class Menu {
    public void accessMenu() throws IOException {
        FileHandler fileHandler = new FileHandler();

        Scanner input = new Scanner(System.in);

        String choice = "";
        System.out.println("Welcome to the File Management system:");

        while (!choice.equals("q")) {
            System.out.println();
            System.out.println("""
            info filename  - find information about the 'filename'
            """);
            System.out.println();
            System.out.println("q - to quit the program");
            System.out.println();
            choice = input.nextLine().toLowerCase();
            switch (choice) {
                default:
                    if (choice.startsWith("info")) {
                        // Extract filename from the "info<filename>" command
                        String filename = choice.substring(5).trim();
                        FFile file = fileHandler.getFile(filename);
                        if (file != null) {
                            file.printInfo();
                        } else {
                            System.out.println("File not found: " + filename);
                        }
                    } else if (choice.equals("q")){
                        System.out.println("Quiting the program");
                        input.close();
                        break;
                    } else {
                        System.out.println("Invalid choice. Do you want to try again? y/n");
                        String decision = input.nextLine().trim().toLowerCase();
                        if (!decision.equals("y")) {
                            System.out.println("Quitting the program");
                            choice = "q";
                            input.close();
                        }
                    }
            }
        }
    }
}