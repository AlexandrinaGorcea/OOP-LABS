package models;

import java.util.List;
import java.util.ArrayList;

public class GeneralOperationsM {
    private FacultyManager facultyManager;

    public GeneralOperationsM(FacultyManager facultyManager) {
        this.facultyManager = facultyManager;
    }

    public void createFaculty(String facultyName, String facultyId, StudyField studyField, List<Student> students) {
        Faculty newFaculty = new Faculty(facultyName, facultyId, studyField, students);
        facultyManager.addFaculty(newFaculty);
    }

    private List<Faculty> faculties = new ArrayList<>();
    public List<Faculty> getAllFaculties() {
        return faculties;
    }

    public Faculty findStudentFaculty(String studentId) {
        for (Faculty faculty : facultyManager.getFaculties()) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(studentId)) {
                    return faculty;
                }
            }
        }
        return null; // return null if no matching student is found
    }

}