package Laboratory2.models;

import java.util.ArrayList;
import java.util.List;

public class FacultyManager {
    private List<Faculty> faculties = new ArrayList<>();

    public FacultyManager() {
        faculties.add(new Faculty("MECHANICAL ENGINEERING", "ME", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("SOFTWARE ENGINEERING", "SE", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("FOOD TECHNOLOGY", "FT", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("URBANISM ARCHITECTURE", "UA", new StudyField(), new ArrayList<>()));
        faculties.add(new Faculty("VETERINARY MEDICINE", "VM", new StudyField(), new ArrayList<>()));
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
}