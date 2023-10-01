package models;

import Laboratory2.models.Student;
import java.util.List;

public class Faculty {
    private String name;
    private String abbrev;
    public StudyField field;
    private List<Student> students;

    public Faculty(String name, String abbrev, StudyField field, List<Student> students) {
        this.name = name;
        this.abbrev = abbrev;
        this.field = field;
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

    public StudyField getField() {
        return field;
    }

    public void setField(StudyField field) {
        this.field = field;
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled students in " + name + " (" + abbrev + "):");
        for (Student student : students) {
            if ("Enrolled".equals(student.getStatus())) {
                System.out.println(student.toString());
            }
        }
    }

    public void displayGraduates() {
        System.out.println("Graduates from " + name + " (" + abbrev + "):");
        for (Student student : students) {
            if ("Graduated".equals(student.getStatus())) {
                System.out.println(student.toString());
            }
        }
    }

    public boolean isStudentInFaculty(String email) {
        for (Student student : students) {
            if (email.equals(student.getEmail())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " - " + abbrev + " - " + field;
    }
}