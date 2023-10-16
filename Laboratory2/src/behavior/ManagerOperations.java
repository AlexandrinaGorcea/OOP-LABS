package behavior;

import models.Operations;
import models.Student;
import models.Faculty;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ManagerOperations {
    private Operations operations;
    private Scanner scanner;

    public ManagerOperations() {
        this.scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();
        this.operations = new Operations(students, faculties);
    }

    public void run() throws ParseException {
        System.out.println("Welcome to TUM's student management system!");
        while (true) {
            displayMainMenu();
            String choice = getUserChoice();

            switch (choice) {
                case "g":
                    GeneralOperations.generalOperations(scanner, operations);
                    break;
                case "f":
                    FacultyOperations.facultyOperations(scanner, operations);
                    break;
                case "q":
                    System.out.println("Quit the program");
                    System.exit(0);  // This line is added
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\nMAIN MENU:");
        System.out.println("""
        g - General Operations
        f - Faculty Operations
        q - Quit
        """);
    }

    private String getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine().trim();
    }
}