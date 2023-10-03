package models;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;


public class StudentManager {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private List<Student> students = new ArrayList<>();

    public StudentManager() {
        try {
            students.add(new Student("Ion", "Popescu", "ion.popescu@email.com", sdf.parse("11.02.2018"), sdf.parse("01.01.2000")));
            students.add(new Student("Ana", "Ionescu", "ana.ionescu@email.com", sdf.parse("12.03.2017"), sdf.parse("02.02.1999")));
            students.add(new Student("Vasile", "Mihai", "vasile.mihai@email.com", sdf.parse("13.04.2016"), sdf.parse("03.03.1998")));
            students.add(new Student("Maria", "Pop", "maria.pop@email.com", sdf.parse("14.05.2015"), sdf.parse("04.04.1997")));
            students.add(new Student("Adrian", "Vasilescu", "adrian.vasilescu@email.com", sdf.parse("15.06.2014"), sdf.parse("05.05.1996")));
            students.add(new Student("Elena", "Marin", "elena.marin@email.com", sdf.parse("16.07.2013"), sdf.parse("06.06.1995")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void createAndAssignStudent(String firstName, String lastName, String email, Date enrollmentDate, Date dateOfBirth, String facultyName, FacultyManager facultyManager) {
        // Check if the faculty exists
        Faculty faculty = facultyManager.findFacultyByName(facultyName);
        if (faculty == null) {
            // If the faculty does not exist, print an error message and return
            System.out.println("Error: No faculty found with name: " + facultyName);
            return;
        }


        // If the faculty exists, create the student and assign them to the faculty
        Student newStudent = new Student(firstName, lastName, email, enrollmentDate, dateOfBirth);
        faculty.addStudent(newStudent);
        students.add(newStudent);
        System.out.println("Added student: " + firstName + " " + lastName);
    }

    public void graduateStudents(String facultyName, FacultyManager facultyManager) {
        Faculty faculty = facultyManager.findFacultyByName(facultyName);
        if (faculty == null) {
            System.out.println("Faculty not found.");
            return;
        }

        List<Student> graduatedStudents = new ArrayList<>();
        for (Student student : faculty.getStudents()) {
            if (getYearsOfStudy(student.getEnrollmentDate()) >= 4) {
                graduatedStudents.add(student);
                student.setStatus("Graduated");
            }
        }

        faculty.getStudents().removeAll(graduatedStudents);
    }

    public List<Student> getGraduates() {
        List<Student> graduates = new ArrayList<>();
        for (Student student : students) {
            if (student.isGraduated()) {
                graduates.add(student);
            }
        }
        return graduates;
    }

    private int getYearsOfStudy(Date enrollmentDate) {
        Calendar now = Calendar.getInstance();
        Calendar enrollment = Calendar.getInstance();
        enrollment.setTime(enrollmentDate);
        return now.get(Calendar.YEAR) - enrollment.get(Calendar.YEAR);
    }
}