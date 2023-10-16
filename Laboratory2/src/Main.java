import behavior.ManagerOperations;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        ManagerOperations managerOperations = new ManagerOperations();
        try {
            managerOperations.run();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}