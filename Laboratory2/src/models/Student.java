package models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private final Date enrollmentDate;
    private final Date dateOfBirth;
    private Boolean graduated;
    private String facultyAbbreviation;

    public Student(String firstName, String lastName, String email, Date enrollmentDate, Date dateOfBirth, String isGraduated){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.dateOfBirth = dateOfBirth;
        this.graduated = graduated;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public Boolean isGraduated() {
        return graduated;
    }


    public void connectToFaculty(Faculty faculty) {
        faculty.addStudent(this);
    }

    public String getFacultyAbbreviation() {
        return facultyAbbreviation;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public void graduate() {
        this.graduated = true;
    }

}