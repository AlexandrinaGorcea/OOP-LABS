package behavior;

import behavior.FacultyOperations;
import behavior.GeneralOperations;
import models.Operations;

import java.text.ParseException;
import java.util.Scanner;

public class ManagerOperations {
    private Operations operations;
    private Scanner scanner;

    public ManagerOperations() {
        this.scanner = new Scanner(System.in);
        this.operations = new Operations();
    }


    public void run() throws ParseException {
        System.out.println("WELCOME TO THE STUDENT MANAGEMENT SYSTEM !");
        while (true) {
            displayMainMenu();
            String choice = " ";

            switch (choice) {
                case "g":
                    GeneralOperations.generalOperations(scanner);
                    break;
                case "f":
                    FacultyOperations.facultyOperations(scanner);
                    break;
                case "q":
                    System.out.println("Quitting the program");
                    return; // Exit the program when 'q' is chosen.
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\nMAIN MENU:");
        System.out.println("g - General Operations");
        System.out.println("f - Faculty Operations");
        System.out.println("q - Quit");
    }

    private String getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine().trim();
    }
}
