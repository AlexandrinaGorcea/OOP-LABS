import java.io.IOException;
import java.util.Scanner;
import DocumentManagement.DocumentManagement;

public class Menu {
    public void accessMenu() throws IOException {
        DocumentManagement document = new DocumentManagement(); // Create an instance of Document
        Scanner input = new Scanner(System.in);
        String choice = "";

        System.out.println("Welcome to the File Management system:");

        while (!choice.equals("q")) {
            System.out.println();
            System.out.println("commit - update snapshot time");
            System.out.println("info filename - find information about the 'filename'");
            System.out.println("status - display all the changes in the files");
            System.out.println("q - to quit the program");
            System.out.println();

            choice = input.nextLine().toLowerCase();

            switch (choice) {
                case "commit":
                    document.commit(); // Update snapshot time
                    break;
                case "status":
                    document.status("rootFolderPath"); // Display all the changes in the files
                    break;
                default:
                    if (choice.startsWith("info")) {
                        String filename = choice.substring(5).trim();
                        if (!filename.isEmpty()) {
                            document.info(filename); // Display information about the file
                        } else {
                            System.out.println("Please enter a filename.");
                        }
                    } else if (choice.equals("q")) {
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