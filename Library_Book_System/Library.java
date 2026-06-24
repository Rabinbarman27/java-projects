package Library_Book_System;

import java.util.Scanner;
import java.util.ArrayList;

public class Library {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Book> Booklist = new ArrayList<>();

    public void addBooks() {
        System.out.print("Name of the book : ");
        String Title = sc.nextLine();
        System.out.print("Name of the Author : ");
        String Author = sc.nextLine();
        Book b1 = new Book(Title, Author);
        
        Booklist.add(b1);
    }

    public void borrowBook() {
        boolean flag = false;
        System.out.print("Enter title to borrow:");
        String input = sc.nextLine();
        for (Book b : Booklist) {
            if (b.gettitle().equalsIgnoreCase(input)) {
                flag = true;
                if (b.isAvailable()) {
                    b.borrowBook();
                    System.out.println("Borrowed " + b.gettitle() + " Enjoy");
                } else {
                    System.out.println("Book not Available");

                }
            }

        }
        if (!flag) {
            System.out.println("Book not available");
        }
    }

    public void returnBook() {
        boolean flag = false;
        System.out.print("Enter title to return:");
        String input = sc.nextLine();
        for (Book b : Booklist) {
            if (b.gettitle().equalsIgnoreCase(input)) {
                flag = true;
                if (!b.isAvailable()) {
                    b.returnBook();
                    System.out.println(b.gettitle() + " returned. Thank you!");
                } else {
                    System.out.println("Book already available");

                }
            }

        }
        if (!flag) {
            System.out.println("Book not from Stock");
        }
    }

    public void listAvailable() {
        System.out.println("--- AVAILABLE BOOKS ---");
        // for (Book b : Booklist) {
        // System.out.println(b);
        // }
        for (int i = 0; i < Booklist.size(); i++) {
            System.out.println(Booklist.get(i));
        }
    }

    

    public void Search() {
        boolean flag = false;
        System.out.print("Enter title to Search:");
        String input = sc.nextLine();
        for (Book b : Booklist) {
            if (b.gettitle().equalsIgnoreCase(input)) {
                flag = true;
                System.out.println("Book is in Database");

            }
        }
        if (!flag) {
            System.out.println("Book is not in Database");

        }
    }

    public boolean exit() {
        return false;
    }

    public boolean menu() {
        System.out.println("--- MENU ---");
        System.out.println("1. Add\r\n" + //
                "2. Borrow\r\n" + //
                "3. Return\r\n" + //
                "4. List Available\r\n" + //
                "5. Search\r\n" + //
                "6. Exit");
        System.out.print("Choose an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                addBooks();
                break;
            case 2:
                borrowBook();
                ;
                break;
            case 3:
                returnBook();
                break;
            case 4:
                listAvailable();
                break;
            case 5:
                Search();
                break;
            case 6:
                return false;

            default:
                System.out.println("invalid option pick again !");
                menu();
                break;
        }
        return true;
    }

}