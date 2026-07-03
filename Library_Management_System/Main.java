package Library_Management_System;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println(" LIBRARY MANAGEMENT SYSTEM v1.2 ");
        System.out.println("================================");
        boolean isrunning = true;
        Library lib = new Library();
        while (isrunning) {

            isrunning = lib.menu();

        }
    }
}
