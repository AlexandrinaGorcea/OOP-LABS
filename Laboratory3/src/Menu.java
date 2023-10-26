import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void accessMenu() throws IOException {
        FileHandler fileHandler = new FileHandler();
        Document document = new Document();

        Scanner input = new Scanner(System.in);

        String choice = "";
        System.out.println("Welcome to the Document Change Detector system:");
        System.out.println("Last snapshot time: " + document.getSnapshotTime());

        while (!choice.equals("q")) {
            System.out.println();
            System.out.println();
            System.out.println("""
            commit - update snapshot time
            info filename  - find information about the 'filename'
            status - display all the changes in the files""");
            System.out.println();
            System.out.println("q - to quit the program");
            System.out.println();
            choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "commit":
                    document.commit();
                    System.out.println("Snapshot time updated: " + document.getSnapshotTime());
                    break;
                case "status":
                    fileHandler.checkForChanges();
                    break;
                default:
                    if (choice.startsWith("info")) {
                        // Extract filename from the "info<filename>" command
                        String filename = choice.substring(5).trim();
                        File file = fileHandler.getFile(filename);
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