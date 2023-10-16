package behavior;

import models.Operations;
import java.util.Scanner;

public class GeneralOperations {
    public static void generalOperations(Scanner input, Operations operations) {
        String choice = "";
        while (!choice.equals("b")) {
            ManagerText.printGeneralOperation();
            choice = input.nextLine().trim();
            String[] parts = choice.split("/");
            switch (parts[0]) {
                case "nf":
                    if (parts.length == 4) {
                        operations.newFaculty(parts[1], parts[2], parts[3]);
                    } else {
                        System.out.println("Invalid input. Please select a valid option.");
                    }
                    break;
                case "ss":
                    if (parts.length == 2) {
                        operations.searchStudent(parts[1]);
                    } else {
                        System.out.println("Invalid input. Please select a valid option.");
                    }
                    break;
                case "df":
                    if (parts.length > 1) {
                        operations.displayFacultiesByField(parts[1]);
                    } else {
                        operations.displayAllFaculties();
                    }
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}