import models.Faculty;
import models.University;

public class Main {
    public static void main(String[] args) {

        Faculty mer = new Faculty("MECHANICAL ENGINEERING","MER","MECHANICAL_ENGINEERING");
        University tum = new University();
        tum.addFaculty(mer);
        System.out.println(tum);
    }
}
