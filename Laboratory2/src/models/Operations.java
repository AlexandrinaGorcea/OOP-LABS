package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Operations {
    private final List<Student> students;
    private final List<Faculty> faculties;

    public Operations(List<Student> students, List<Faculty> faculties) {
        this.students = students;
        this.faculties = faculties;
    }

    public void createAndAssignStudent(String facultyAbbreviation, String studentFirstName, String studentLastName, String email, String enrollmentDateString, String dateOfBirthString, String extraParameter) throws ParseException {
        Date enrollmentDate = new SimpleDateFormat("dd.MM.yyyy").parse(enrollmentDateString);
        Date dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirthString);

        Faculty faculty = faculties.stream()
                .filter(f -> f.getAbbreviation().equals(facultyAbbreviation))
                .findFirst()
                .orElse(null);

        if (faculty != null) {
            Student student = new Student(studentFirstName, studentLastName, email, enrollmentDate, dateOfBirth, facultyAbbreviation);
            students.add(student);
            student.connectToFaculty(faculty);
            faculty.addStudent(student);
            System.out.println("New student created and assigned to a faculty");
        } else {
            System.out.println("Faculty not found by abbreviation: '" + facultyAbbreviation);
        }
    }

    public void graduateStudent(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                student.graduate();
                System.out.println("This student " + email + " is graduated");
                return;
            }
        }
        System.out.println("This student " + email + "is not found");
    }

    public void isStudentBelongToFaculty(String facultyAbbreviation, String email) {
        for (Student student : students) {
            String studentFacultyAbbreviation = student.getFacultyAbbreviation();
            if (studentFacultyAbbreviation == null) {
                System.out.println("Student with email " + student.getEmail() + " has null faculty abbreviation");
                continue;
            }
            if (student.getEmail().equals(email) && studentFacultyAbbreviation.equals(facultyAbbreviation)) {
                System.out.println("Student with email " + email + " belongs to faculty " + facultyAbbreviation);
                return;
            }
        }
        System.out.println("Student with email " + email + " doesn't belong to faculty " + facultyAbbreviation);
    }

    public void newFaculty(String facultyName, String facultyAbbreviation, String field) {
        StudyField studyField = StudyField.valueOf(field);
        Faculty faculty = new Faculty(facultyName, facultyAbbreviation, studyField);
        faculties.add(faculty);
        System.out.println("New Faculty created");
    }

    public void searchStudent(String email) {
        boolean foundStudent = false;
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                System.out.println("Student found:");
                System.out.println(student.getFirstName() + " " + student.getLastName());
                System.out.println("Belongs to faculty: " + student.getFacultyAbbreviation());
                foundStudent = true;
                break;
            }
        }
        if (!foundStudent) {
            System.out.println("Student with email " + email + " not found.");
        }
    }

    public void displayAllFaculties() {
        System.out.println("The available faculties:");
        for (Faculty faculty : faculties) {
            System.out.println(" - " + faculty.getName() + " (" + faculty.getAbbreviation() + ")");
        }
    }

    public void displayFacultiesByField(String field) {
        if (StudyField.validation(field)) {
            System.out.println("The faculties from the " + field + " field are:");
            boolean foundFaculty = false;
            for (Faculty faculty : faculties) {
                if (faculty.getStudyField().toString().equals(field)) {
                    System.out.println(" - " + faculty.getName());
                    foundFaculty = true;
                }
            }
            if (!foundFaculty) {
                System.out.println("No faculties found in the " + field + " field.");
            }
        }
    }



}