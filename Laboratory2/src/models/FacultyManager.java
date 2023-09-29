package models;

import java.util.ArrayList;
import java.util.List;

public class FacultyManager {
    private List<Faculty> faculties = new ArrayList<>();

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public Faculty findFacultyByName(String name) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(name)) {
                return faculty;
            }
        }
        return null;
    }

    public void createAndAssignStudent(String studentName, String facultyName) {
        // Find the faculty
        Faculty faculty = findFacultyByName(facultyName);
        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        // Create the student
        Student student = new Student(studentName);

        // Assign the student to the faculty
        faculty.getStudents().add(student);
    }

    public void graduateStudents(String facultyName) {
        // Find the faculty
        Faculty faculty = findFacultyByName(facultyName);
        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        // Graduate students who have been enrolled for four years
        List<Student> graduatedStudents = new ArrayList<>();
        for (Student student : faculty.getStudents()) {
            if (student.getYearsOfStudy() >= 4) {
                graduatedStudents.add(student);
            }
        }

        faculty.getStudents().removeAll(graduatedStudents);
    }

    public void displayCurrentStudents() {
        for (Faculty faculty : faculties) {
            System.out.println("Faculty: " + faculty.getName());
            for (Student student : faculty.getStudents()) {
                if (student.getYearsOfStudy() < 4) {
                    System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + ", Email: " + student.getEmail());
                }
            }
        }
    }
}