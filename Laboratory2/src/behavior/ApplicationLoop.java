package Laboratory2.behavior;

import Laboratory2.models.Faculty;
import Laboratory2.models.University;
import models.FacultyManager;

import java.util.Scanner;

public class ApplicationLoop {
    private Scanner scanner;
    private University university;
    private FacultyManager facultyManager;
    private String command;

    public ApplicationLoop() {
        this.scanner = new Scanner(System.in);
        this.university = new University();
        this.facultyManager = new FacultyManager();
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
                Faculty newFaculty = new Faculty(); // Assume you create a new Faculty object here
                facultyManager.addFaculty(newFaculty);
                break;
            case "remove":
                // Remove a faculty
                Faculty facultyToRemove = facultyManager.findFacultyByName(commandsList[2]);
                if (facultyToRemove != null) {
                    facultyManager.removeFaculty(facultyToRemove);
                }
                break;
            case "find":
                // Find a faculty
                Faculty foundFaculty = facultyManager.findFacultyByName(commandsList[2]);
                if (foundFaculty != null) {
                    System.out.println("Found faculty: " + foundFaculty);
                }
                break;
            default:
                System.out.println("Invalid faculty command");
        }
    }

    private void handleStudentCommands(String[] commands) {
        if (commands.length < 2) {
            System.out.println("Missing command");
            return;
        }

        switch (commands[1]) {
            case "create":
                // Create a student
                String studentName = commandsList[2];
                String facultyName = commandsList[3];
                facultyManager.createAndAssignStudent(studentName, facultyName);
                break;
            case "graduate":
                // Graduate a student
                facultyManager.graduateStudents(commandsList[2]);
                break;
            case "display":
                // Display students
                facultyManager.displayCurrentStudents();
                break;
            default:
                System.out.println("Invalid student command");
        }
    }
}