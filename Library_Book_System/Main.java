package Library_Book_System;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("    LIBRARY BOOK SYSTEM v1.0    ");
        System.out.println("================================");
        boolean isrunning = true;
        Library lib = new Library();
        while (isrunning) {

            isrunning = lib.menu();
            
        }
    }
}
