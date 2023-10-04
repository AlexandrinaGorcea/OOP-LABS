package models;

import behavior.ManagerText;
import java.util.Scanner;

public class Menu {
    public static void accessMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        ManagerText.printManagerText();

        while (!choice.equals("q")) {
            choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "g":
                    ManagerText.printGeneralOperation();
                    break;
                case "f":
                    ManagerText.printFacultyOperation();
                    break;
                case "q":
                    System.out.println("Quit");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}

