package Library_Management_System;

import java.util.HashMap;
import java.util.Scanner;

public class Library {
    static Scanner sc = new Scanner(System.in);
    private HashMap<String, Book> catalogue = new HashMap<>();

    Library() {
        Book b1 = new Book("Clean Code", "Robert Martin");
        Book b2 = new Book("1984", "George Orwell");

        catalogue.put(("Clean code").toLowerCase(), b1);
        catalogue.put(("1984").toLowerCase(), b2);

    }

    public void borrowBook() {
        System.err.print("Enter title to borrow: ");
        String title = sc.nextLine();
        if (!catalogue.containsKey(title.toLowerCase())) {
            throw new BookNotFoundException("Book not found in the system");
        }
        Book book = catalogue.get(title.toLowerCase());
        if (book.getAvailable()) {
            book.borrowB();
            System.out.println("Borrowed '" + title + "'.Enjoy !");
        } else {
            System.out.println("Sorry ,'" + title + "'is Currently borrowed by someone");
        }
    }

    public void returnBook() {
        System.err.print("Enter title to borrow: ");
        String title = sc.nextLine();
        if (!catalogue.containsKey(title.toLowerCase())) {
            throw new BookNotFoundException("Book not found in the system");
        }
        Book book = catalogue.get(title.toLowerCase());
        if (!book.getAvailable()) {
            book.returnB();
            System.out.println("returned '" + title + "'Thank you!");
        } else {
            System.out.println("Sorry ,'" + title + "'is already in the System");
        }
    }

    public void AddBook() {
        System.err.print("Enter title to borrow: ");
        String title = sc.nextLine();
        System.err.print("Enter Author to borrow: ");
        String Author = sc.nextLine();
        Book b = new Book(title, Author);
        catalogue.put(title.toLowerCase(), b);
        System.out.println(title + "Has been added to the inventory , Thank you!.");

    }

    public void SearchBook() {
        System.err.print("Enter title to Search: ");
        String title = sc.nextLine();
        Book book = catalogue.get(title.toLowerCase());
        if (!catalogue.containsKey(title.toLowerCase())) {
            throw new BookNotFoundException("Book not found in the system");
        } else {
            if (!book.getAvailable()) {
                System.out.println("Book is borrowed by someone");
            } else {
                System.out.println("Book is available in the inventory");
            }
        }
    }

    public void listBooks() {
        System.out.println("--- AVAILABLE BOOKS ---");
        for (Book b : catalogue.values()) {
            System.out.println(b.toString());
        }
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
                AddBook();
                break;
            case 2:
                borrowBook();
                ;
                break;
            case 3:
                returnBook();
                break;
            case 4:
                listBooks();
                break;
            case 5:
                SearchBook();
                break;
            case 6:
                return false;
            default:
                System.out.println("invalid option pick again !");
                break;
        }
        return true;
    }

}
