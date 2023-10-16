package behavior;

public class ManagerText {

    public static void printManagerText(){
        System.out.println("Welcome to TUM's student management system!");
        System.out.println("""
        What do you want to do?
        
        g - General operations
        f - Faculty operations
        
        q - Quit program
        
        Your input: 
    """);
    }
    public static void printGeneralOperation() {
        System.out.println("\nGENERAL OPERATIONS MENU:");
        System.out.println("""
        What do you want to do?"
        
        nf/<faculty name>/<faculty abbreviation>/<field>- New Faculty
        ss/<student email> - Search Student
        df - Display Faculties
        
        b - Back
        
        Your input: 
        """);
    }


    public static void printFacultyOperation(){
        System.out.println("\nFACULTY OPERATIONS MENU:");
        System.out.println("""
        What do you want to do?
        
        ns/<faculty abbreviation>/<first name>/<last name>/<email>/<enrollmentDate>/<dateOfBirth> - create a new student
        gs/<email> - graduate student
        ds/<faculty abbreviation> - display enrolled students
        dg/<faculty abbreviation> - display graduated students
        bf/<faculty abbreviation>/<email> - check if a student belongs to faculty
        
        b - Back
        
        Your input: 
        """);
    }


}