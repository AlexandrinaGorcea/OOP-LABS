package models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final String name;
    private final String abbreviation;
    private List<Student> students;
    private final StudyField studyField;
    private static final List<Faculty> facultyList = new ArrayList<>();


    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public static List<Faculty> getFacultyList() {
        return facultyList;
    }
    public static void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public static Faculty findFacultyByAbbrev(List<Faculty> faculties, String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }
}
