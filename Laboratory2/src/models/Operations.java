package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

    public class Operations {
        private static final List<Student> students = Student.getStudentsList();
        private static final List<Faculty> faculties = Faculty.getFacultyList();

        public static void createAndAssignStudent(String[] commands) throws ParseException {
            if (commands.length == 6) {

                String facultyAbbreviation = commands[1];
                String studentFirstName = commands[2];
                String studentLastName = commands[3];
                String email = commands[4];
                Date enrollmentDate = new SimpleDateFormat("dd.MM.yyyy").parse(commands[5]);
                Date dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(commands[6]);

                Faculty faculty = Faculty.findFacultyByAbbreviation(faculties, facultyAbbreviation);

                if (faculty != null) {
                    Student student = new Student(studentFirstName, studentLastName, email, enrollmentDate, dateOfBirth, facultyAbbreviation);
                    Student.addStudent(student);
                    student.connectToFaculty(faculty);
                    faculty.addStudent(student);
                    System.out.println("New student created and assigned to a faculty");
                } else {
                    System.out.println("Faculty not found for abbreviation: '" + facultyAbbreviation);
                }
            } else {
                System.out.println("Invalid input. Please select a valid option.");
            }
        }

        public static void graduateStudent(String[] parts) {
            if (parts.length == 2) {
                String email = parts[1];
                for (Student student : students) {
                    if (student.getEmail().equals(email)) {
                        student.graduate();
                        System.out.println("This student " + email + " is graduated");
                        return;
                    }
                }
                System.out.println("This student " + email + "is not found");
            } else {
                System.out.println("Invalid input. Please select a valid option.");
            }
        }

        public static void isStudentBelongToFaculty(String[] commands) {
            if (commands.length == 3) {
                String facultyAbbreviation = commands[1];
                String email = commands[2];
                for (Student student : students) {
                    if (student.getEmail().equals(email) && student.getFacultyAbbreviation().equals(facultyAbbreviation)) {
                        System.out.println("Student with email " + email + " belongs to faculty " + facultyAbbreviation);
                        return;
                    }
                }
                System.out.println("Student with email " + email + " doesn't belong to faculty " + facultyAbbreviation);
            } else {
                System.out.println("Invalid input. Please select a valid option.");
            }
        }

        public static void newFaculty(String[] commands) {
            if (commands.length == 4) {
                String facultyName = commands[1];
                String facultyAbbreviation = commands[2];
                StudyField studyField = StudyField.valueOf(commands[3]);
                Faculty faculty = new Faculty(facultyName, facultyAbbreviation, studyField);
                Faculty.addFaculty(faculty);
                System.out.println("New Faculty create");
            } else {
                System.out.println("Invalid input. Please select a valid option.");
            }
        }

        public static void searchStudent(String[] commands) {
            if (commands.length == 2) {
                String email = commands[1];
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
            } else {
                System.out.println("Invalid input. Please select a valid option.");
            }

        }

        public static void displayAllFaculties(String[] parts) {
            System.out.println("The available faculties:");
            for (Faculty faculty : faculties) {
                System.out.println(" - " + faculty.getName());
            }

        }

        public static void displayFacultiesByField(String[] commands) {
            if (commands.length == 2) {
                String field = commands[1];
                if (StudyField.validation(field)) {
                    System.out.println("The faculties from the " + field + " field are:");
                    for (Faculty faculty : faculties) {
                        if (faculty.getStudyField().toString().equals(field)) {
                            System.out.println(" - " + faculty.getName());
                        }
                    }

                }


            }
        }
    }

