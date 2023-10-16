import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Student;
import models.Faculty;
import models.Operations;
import behavior.GeneralOperations;
import behavior.FacultyOperations;

public class Menu {
    public static void accessMenu() {
        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Faculty> faculties = new ArrayList<>();
        Operations operations = new Operations(students, faculties);

        while (true) {
            System.out.println("Welcome to TUM's student management system!");
            System.out.println("What do you want to do?");
            System.out.println("g - General Operations");
            System.out.println("f - Faculty Operations");
            System.out.println("q - Quit Program");

            String choice = input.nextLine().trim();
            switch (choice) {
                case "g":
                    GeneralOperations.generalOperations(input, operations);
                    break;
                case "f":
                    FacultyOperations.facultyOperations(input, operations);
                    break;
                case "q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}