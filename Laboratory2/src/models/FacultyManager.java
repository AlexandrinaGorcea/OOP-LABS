package Laboratory2.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class FacultyManager {
    private String universityName = "Technical University of Moldova";
    private List<Faculty> faculties = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public FacultyManager() {
        // Create faculties
        faculties.add(new Faculty("MECHANICAL ENGINEERING", "ME", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("SOFTWARE ENGINEERING", "SE", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("FOOD TECHNOLOGY", "FT", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("URBANISM ARCHITECTURE", "UA", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("VETERINARY MEDICINE", "VM", new StudyField(), new ArrayList<>()));

        // Create students with different enrollment dates and dates of birth
        try {
            Student student1 = new Student("Ion", "Popescu", "ion.popescu@email.com", sdf.parse("11.02.2018"), sdf.parse("01.01.2000"));
            Student student2 = new Student("Ana", "Ionescu", "ana.ionescu@email.com", sdf.parse("12.03.2017"), sdf.parse("02.02.1999"));
            Student student3 = new Student("Vasile", "Mihai", "vasile.mihai@email.com", sdf.parse("13.04.2016"), sdf.parse("03.03.1998"));
            Student student4 = new Student("Maria", "Pop", "maria.pop@email.com", sdf.parse("14.05.2015"), sdf.parse("04.04.1997"));
            Student student5 = new Student("Adrian", "Vasilescu", "adrian.vasilescu@email.com", sdf.parse("15.06.2014"), sdf.parse("05.05.1996"));
            Student student6 = new Student("Elena", "Marin", "elena.marin@email.com", sdf.parse("16.07.2013"), sdf.parse("06.06.1995"));

            // Assign students to faculties
            faculties.get(0).getStudents().add(student1);
            faculties.get(1).getStudents().add(student2);
            faculties.get(2).getStudents().add(student3);
            faculties.get(3).getStudents().add(student4);
            faculties.get(4).getStudents().add(student5);
            faculties.get(4).getStudents().add(student6);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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

        // Check if the faculty's list of students is not null
        if (faculty.getStudents() == null) {
            faculty.setStudents(new ArrayList<>());
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
            if (getYearsOfStudy(student.getEnrollmentDate()) >= 4) {
                graduatedStudents.add(student);
                student.setStatus("Graduated"); // assuming Student class has a setStatus method
            }
        }

        faculty.getStudents().removeAll(graduatedStudents);
    }

    public void displayCurrentStudents() {
        for (Faculty faculty : faculties) {
            System.out.println("Faculty: " + faculty.getName());
            for (Student student : faculty.getStudents()) {
                if (getYearsOfStudy(student.getEnrollmentDate()) < 4) {
                    System.out.println("Student: " + student.getFirstName() + " " + student.getLastName() + ", Email: " + student.getEmail());
                }
            }
        }
    }

    public void displayGraduates() {
        for (Faculty faculty : faculties) {
            System.out.println("Faculty: " + faculty.getName());
            for (Student student : faculty.getStudents()) {
                if (getYearsOfStudy(student.getEnrollmentDate()) >= 4) {
                    System.out.println("Graduate: " + student.getFirstName() + " " + student.getLastName() + ", Email: " + student.getEmail());
                }
            }
        }
    }

    public boolean studentBelongsToFaculty(Student student, Faculty faculty) {
        return faculty.getStudents().contains(student);
    }

    private int getYearsOfStudy(Date enrollmentDate) {
        Calendar now = Calendar.getInstance();
        Calendar enrollment = Calendar.getInstance();
        enrollment.setTime(enrollmentDate);
        return now.get(Calendar.YEAR) - enrollment.get(Calendar.YEAR);
    }
}