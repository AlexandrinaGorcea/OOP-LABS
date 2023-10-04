package behavior;

import java.text.ParseException;
import java.util.Scanner;

import models.Operations;

public class GeneralOperations {
    public static void generalOperations(Scanner input) throws ParseException {
        String choice = "";
        while (!choice.equals("b")) {
            ManagerText.printGeneralOperation();
            choice = input.nextLine().trim();
            String[] parts = choice.split("/");
            switch (parts[0]) {
                case "nf":
                    Operations.newFaculty(parts);
                    break;
                case "ss":
                    Operations.searchStudent(parts);
                    break;
                case "df":
                    if (parts.length > 1) {
                        Operations.displayFacultiesByField(parts);
                    } else {
                        Operations.displayAllFaculties(parts);
                    }
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option. y/n");
                    String decision = input.nextLine().trim().toLowerCase();
                    if (!decision.equals("y")) {
                        System.out.println("Going back");
                        choice = "b";
                    }
            }
        }
    }
}