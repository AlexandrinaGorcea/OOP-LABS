package behavior;

import java.text.ParseException;
import java.util.Scanner;

import models.Operations;

public class FacultyOperations {
    public static void facultyOperations(Scanner input) throws ParseException {
        String choice = "";
        while (!choice.equals("b")) {
            ManagerText.printFacultyOperation();
            choice = input.nextLine().trim();
            String[] parts = choice.split("/");
            switch (parts[0]) {
                case "ns":
                    Operations.createAndAssignStudent(parts);
                    break;
                case "gs":
                    Operations.graduateStudent(parts);
                    break;
                case "ds":
                    Operations.displayAllFaculties(parts);
                    break;
                case "dg":
                    Operations.displayFacultiesByField(parts);
                    break;
                case "bf":
                    Operations.isStudentBelongToFaculty(parts);
                    break;
                case "b":
                    return;
                default:
                    System.out.println("Invalid choice. Try again y/n");
                    String decision = input.nextLine().trim().toLowerCase();
                    if (!decision.equals("y")) {
                        System.out.println("Go back");
                        choice = "b";
                    }
            }
        }
    }
}