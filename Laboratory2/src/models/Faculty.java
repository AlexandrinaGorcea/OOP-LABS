package models;

import java.util.List;

public class Faculty {
    private String name;
    private String abbrev;
    private StudyField field; // changed from String to StudyField
    private List<Student> students; // added

    public Faculty(String name, String abbrev, StudyField field, List<Student> students) {
        this.name = name;
        this.abbrev = abbrev;
        this.field = field;
        this.students = students; // added
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

    @Override
    public String toString() {
        return name + " - " + abbrev + " - " + field;
    }
}