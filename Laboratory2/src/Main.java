import models.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        FacultyManager facultyManager = new FacultyManager();
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

       // for (Faculty faculty : facultyManager.getFaculties()) {
         //   System.out.println(faculty.getName());
        //}

        while (true) {
            System.out.print("write command> ");
            String command = scanner.nextLine();
            String[] commands = command.split(" ");

            try {
                if (commands[0].equals("f") && commands[1].equals("add")) {
                    String facultyName = commands[2];
                    String abbrev = commands[3];
                    String studyFieldName = commands[4];
                    Faculty newFaculty = new Faculty(facultyName, abbrev, new StudyField(studyFieldName), new ArrayList<>());
                    facultyManager.addFaculty(newFaculty);
                    System.out.println("Added faculty: " + facultyName);
                } else if (commands[0].equals("f") && commands[1].equals("displayAll")) {
                    for (Faculty faculty : facultyManager.getFaculties()) {
                        System.out.println(faculty.getName());
                    }
                } else if (commands[0].equals("s") && commands[1].equals("create")) {
                    String firstName = commands[2];
                    String lastName = commands[3];
                    String email = commands[4];
                    Date enrollmentDate = new SimpleDateFormat("dd.MM.yyyy").parse(commands[5]);
                    Date dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(commands[6]);
                    String facultyName = commands[7];
                    studentManager.createAndAssignStudent(firstName, lastName, email, enrollmentDate, dateOfBirth, facultyName, facultyManager);
                    System.out.println("Added student: " + firstName + " " + lastName);
                } else if (commands[0].equals("s") && commands[1].equals("graduate")) {
                    String facultyName = commands[2];
                    studentManager.graduateStudents(facultyName, facultyManager);
                    System.out.println("Graduated students from faculty: " + facultyName);
                } else if (commands[0].equals("f") && commands[1].equals("display")) {
                    String facultyName = commands[2];
                    Faculty faculty = facultyManager.findFacultyByName(facultyName);
                    if (faculty != null) {
                        for (Student student : faculty.getStudents()) {
                            System.out.println(student.getFirstName() + " " + student.getLastName());
                        }
                    } else {
                        System.out.println("Faculty not found.");
                    }
                } else if (commands[0].equals("s") && commands[1].equals("display")) {
                    String status = commands[2];
                    if (status.equals("graduates")) {
                        for (Student student : studentManager.getGraduates()) {
                            System.out.println(student.getFirstName() + " " + student.getLastName());
                        }
                    } else {
                        System.out.println("Invalid command");
                    }
                } else if (commands[0].equals("s") && commands[1].equals("belongs")) {
                    String email = commands[2];
                    boolean belongs = false;
                    for (Faculty faculty : facultyManager.getFaculties()) {
                        for (Student student : faculty.getStudents()) {
                            if (student.getEmail().equals(email)) {
                                System.out.println(student.getFirstName() + " " + student.getLastName() + " belongs to " + faculty.getName());
                                belongs = true;
                                break;
                            }
                        }
                        if (belongs) {
                            break;
                        }
                    }
                    if (!belongs) {
                        System.out.println("Student not found.");
                    }
                } else if (commands[0].equals("f") && commands[1].equals("displayAll")) {
                    for (Faculty faculty : facultyManager.getFaculties()) {
                        System.out.println(faculty.getName());
                    }
                } else if (commands[0].equals("f") && commands[1].equals("displayByField")) {
                    String studyFieldName = commands[2];
                    for (Faculty faculty : facultyManager.getFaculties()) {
                        if (faculty.getStudyField().getName().equals(studyFieldName)) {
                            System.out.println(faculty.getName());
                        }
                    }
                } else {
                    System.out.println("Invalid command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}