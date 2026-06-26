package Vehicle_Rental_System;

public class Main {

    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("  VEHICLE RENTAL SYSTEM v1.0  ");
        System.out.println("==============================");
        Program p1 = new Program();
        boolean session = true;
        while (session) {
            session=p1.menu();

        }

    }
}
