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

    public List<Student> getEnrolledStudents() {
        List<Student> enrolledStudents = new ArrayList<>();
        for (Student student : students) {
            if ("Enrolled".equals(student.getStatus())) {
                enrolledStudents.add(student);
            }
        }
        return enrolledStudents;
    }

    public List<Student> getGraduates() {
        List<Student> graduates = new ArrayList<>();
        for (Student student : students) {
            if ("Graduated".equals(student.getStatus())) {
                graduates.add(student);
            }
        }
        return graduates;
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
        return name + " - " + abbrev + " - " + studyField.getName();
    }
}