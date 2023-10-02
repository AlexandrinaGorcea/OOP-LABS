package behavior;

import models.Faculty;
import models.University;
import models.FacultyManager;
import models.StudentManager;
import models.Student;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ApplicationLoop {
    private Scanner scanner;
    private University university;
    private FacultyManager facultyManager;
    private StudentManager studentManager;
    private String command;
    private String facultyName;
    private Faculty faculty;

    public ApplicationLoop() {
        this.scanner = new Scanner(System.in);
        this.university = new University();
        this.facultyManager = new FacultyManager();
        this.studentManager = new StudentManager();
        this.command = "";
    }

    public void run() {
        System.out.println("Welcome to TUM's student management system!");
        System.out.println("What do you want to do?");

        while (!this.command.equals("q")) {
            this.command = takeUserInput();

            String[] commandsList = this.command.split("/");

            switch (commandsList[0]) {
                case "f":
                    handleFacultyCommands(commandsList);
                    break;
                case "s":
                    handleStudentCommands(commandsList);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
        scanner.close();
    }

    private String takeUserInput() {
        System.out.print("write command> ");
        return scanner.nextLine();
    }

    private void handleFacultyCommands(String[] commands) {
        if (commands.length < 2) {
            System.out.println("Missing command");
            return;
        }

        switch (commands[1]) {
            case "add":
                // Add a faculty
                // You need to provide the correct parameters to create a new Faculty object
                break;
            case "remove":
                // Remove a faculty
                Faculty facultyToRemove = facultyManager.findFacultyByName(commands[2]);
                if (facultyToRemove != null) {
                    facultyManager.removeFaculty(facultyToRemove);
                }
                break;
            case "find":
                // Find a faculty
                Faculty foundFaculty = facultyManager.findFacultyByName(commands[2]);
                if (foundFaculty != null) {
                    System.out.println("Found faculty: " + foundFaculty);
                }
                break;
            default:
                System.out.println("Invalid faculty command");
        }
    }

    private void handleStudentCommands(String[] commands) {
        if (commands.length < 8) {
            System.out.println("Missing command");
            return;
        }

        try {
            switch (commands[1]) {
                case "create":
                    // Create a student
                    String firstName = commands[2];
                    String lastName = commands[3];
                    String email = commands[4];
                    Date enrollmentDate = new SimpleDateFormat("dd.MM.yyyy").parse(commands[5]);
                    Date dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(commands[6]);
                    facultyName = commands[7];
                    studentManager.createAndAssignStudent(firstName, lastName, email, enrollmentDate, dateOfBirth, facultyName, facultyManager);
                    break;
                case "graduate":
                    // Graduate a student
                    studentManager.graduateStudents(commands[2], facultyManager);
                    break;
                case "displayEnrolled":
                    // Display currently enrolled students
                    facultyName = commands[2];
                    faculty = facultyManager.findFacultyByName(facultyName);
                    if (faculty != null) {
                        List<Student> enrolledStudents = faculty.getEnrolledStudents();
                        for (Student student : enrolledStudents) {
                            System.out.println(student);
                        }
                    }
                    break;
                case "displayGraduates":
                    // Display graduates
                    List<Student> graduates = studentManager.getGraduates();
                    for (Student graduate : graduates) {
                        System.out.println(graduate);
                    }
                    break;
                case "isInFaculty":
                    // Check if a student belongs to a faculty
                    String studentEmail = commands[2];
                    facultyName = commands[3];
                    faculty = facultyManager.findFacultyByName(facultyName);
                    if (faculty != null) {
                        if (faculty.isStudentInFaculty(studentEmail)) {
                            System.out.println("The student is in the faculty.");
                        } else {
                            System.out.println("The student is not in the faculty.");
                        }
                    } else {
                        System.out.println("Faculty not found.");
                    }
                    break;
                case "displayByField":
                    if (commands.length < 3) {
                        System.out.println("Missing field name");
                        return;
                    }
                    String fieldName = commands[2];
                    List<Faculty> facultiesByField = facultyManager.getFacultiesByField(fieldName);
                    if (facultiesByField.isEmpty()) {
                        System.out.println("No faculties found for field: " + fieldName);
                    } else {
                        for (Faculty faculty : facultiesByField) {
                            System.out.println(faculty);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid student command");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}