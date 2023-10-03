package models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String abbrev;
    private StudyField studyField;
    private List<Student> students;

    public Faculty(String name, String abbrev, StudyField studyField, List<Student> students) {
        this.name = name;
        this.abbrev = abbrev;
        this.studyField = studyField;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudyField(StudyField studyField) {
        this.studyField = studyField;
    }

    public List<Student> getStudentsByStatus(String status) {
        List<Student> studentsByStatus = new ArrayList<>();
        for (Student student : students) {
            if (status.equals(student.getStatus())) {
                studentsByStatus.add(student);
            }
        }
        return studentsByStatus;
    }

    public List<Student> getEnrolledStudents() {
        return getStudentsByStatus("Enrolled");
    }

    public List<Student> getGraduates() {
        return getStudentsByStatus("Graduated");
    }

    public boolean isStudentInFaculty(String email) {
        for (Student student : students) {
            if (email.equals(student.getEmail())) {
                return true;
            }
        }
        return false;
    }
    public void addStudent(Student newStudent) {
        // Check if the students list is null
        if (this.students == null) {
            // If it's null, initialize it
            this.students = new ArrayList<>();
        }

        // Add the new student to the list
        this.students.add(newStudent);
    }

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name + " - " + abbrev + " - " + studyField.getName();
    }


}