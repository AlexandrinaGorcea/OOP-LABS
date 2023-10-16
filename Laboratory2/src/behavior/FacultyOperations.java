package behavior;

import models.Operations;
import java.text.ParseException;
import java.util.Scanner;

public class FacultyOperations {
    public static void facultyOperations(Scanner input, Operations operations) throws ParseException {
        String choice = "";
        while (!choice.equals("b")) {
            ManagerText.printFacultyOperation();
            choice = input.nextLine().trim();
            String[] parts = choice.split("/");
            switch (parts[0]) {
                case "ns":
                    if (parts.length == 8) {
                        operations.createAndAssignStudent(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
                    } else {
                        System.out.println("Invalid input. Please select a valid option.");
                    }
                    break;
                case "gs":
                    if (parts.length == 2) {
                        operations.graduateStudent(parts[1]);
                    } else {
                        System.out.println("Invalid input. Please select a valid option.");
                    }
                    break;
                case "is":
                    if (parts.length == 3) {
                        operations.isStudentBelongToFaculty(parts[1], parts[2]);
                    } else {
                        System.out.println("Invalid input. Please select a valid option.");
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