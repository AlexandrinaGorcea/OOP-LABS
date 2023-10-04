package models;

import behavior.ManagerText;
import models.Operations;

import java.util.Scanner;

public class Menu {
    public static void accessMenu(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ManagerText.printManagerText();

        String choice;
        while (true) {
            choice = scanner.nextLine().trim().toLowerCase();
            switch (choice) {
                case "g":
                    ManagerText.printGeneralOperation();
                    // Call methods from Operations class for general operations
                    break;
                case "f":
                    ManagerText.printFacultyOperation();
                    // Call methods from Operations class for faculty operations
                    break;
                case "s":
                    // Handle student operations
                    break;
                case "q":
                    System.out.println("Quitting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");

            }
        }
    }
}
