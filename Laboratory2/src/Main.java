import models.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FacultyManager manager = new FacultyManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command:");
            String command = scanner.nextLine();

            if (command.equals("quit")) {
                break;
            } else if (command.startsWith("createAndAssignStudent")) {
                String[] parts = command.split(" ");
                if (parts.length == 3) {
                    manager.createAndAssignStudent(parts[1], parts[2]);
                } else {
                    System.out.println("Invalid command. Usage: createAndAssignStudent <studentName> <facultyName>");
                }
            } else {
                System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}