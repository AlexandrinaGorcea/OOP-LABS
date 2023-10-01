package models;

import java.util.ArrayList;
import java.util.List;

public class FacultyManager {
    private List<Faculty> faculties = new ArrayList<>();

    public FacultyManager() {
        faculties.add(new Faculty("MECHANICAL ENGINEERING", "ME", new StudyField("Mechanical Engineering"), new ArrayList<>()));
        faculties.add(new Faculty("SOFTWARE ENGINEERING", "SE", new StudyField("Software Engineering"), new ArrayList<>()));
        faculties.add(new Faculty("FOOD TECHNOLOGY", "FT", new StudyField("Food Technology"), new ArrayList<>()));
        faculties.add(new Faculty("URBANISM ARCHITECTURE", "UA", new StudyField("Urbanism Architecture"), new ArrayList<>()));
        faculties.add(new Faculty("VETERINARY MEDICINE", "VM", new StudyField("Veterinary Medicine"), new ArrayList<>()));
    }

    public void addFaculty(Faculty faculty) {
        if (faculty == null) {
            throw new IllegalArgumentException("Faculty cannot be null.");
        }
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        if (faculty == null) {
            throw new IllegalArgumentException("Faculty cannot be null.");
        }
        faculties.remove(faculty);
    }

    public Faculty findFacultyByName(String name) {
        for (Faculty faculty : faculties) {
            if (faculty.getName().equals(name)) {
                return faculty;
            }
        }
        throw new IllegalArgumentException("No faculty found with name: " + name);
    }
}