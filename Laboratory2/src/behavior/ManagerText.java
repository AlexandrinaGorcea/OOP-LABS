package behavior;

import models.Operations;

public class ManagerText {

    public static void printManagerText(){
        System.out.println("Welcome to TUM's student management system!");
        System.out.println("What do you want to do?");
        System.out.println("g - General operations");
        System.out.println("f - Faculty operations");
        System.out.println("s - Student operations");
        System.out.println();
        System.out.println("q - Quit program");
        System.out.println();
        System.out.print("Your input: ");
    }
    public static void printGeneralOperation() {
        System.out.println("\nGENERAL OPERATIONS MENU:");
        System.out.println("nf - New Faculty");
        System.out.println("ss - Search Student");
        System.out.println("df - Display Faculties");
        System.out.println("b - Back");
        System.out.print("Your input: ");
    }


    public static void printFacultyOperation(){
        System.out.println("Faculty operations");
        System.out.println("What do you want to do?");
        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - enroll a new student");
        System.out.println("gs/<email> - graduate student");
        System.out.println("ds/<faculty abbreviation> - display enrolled students");
        System.out.println("dg/<faculty abbreviation> - display graduated students");
        System.out.println("bf/<faculty abbreviation>/<email> - check if a student belongs to faculty");
        System.out.println();
        System.out.println("b - Back");
        System.out.print("Your input: ");
    }


}