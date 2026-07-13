package MiniContactBook;

import java.util.HashMap;
import java.util.*;
import java.io.*;

public class ContactBook {
    String name;
    String phone;

    ContactBook(String name, String phone) {
        this.name = name;
        this.phone = phone;

    }

    ContactBook() {

    }

    public String getName() {
        return name.toLowerCase();
    }

    public String getPhone() {
        return phone;
    }


    private HashMap<String, String> contacts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static final String File_NAME = "contacts.txt";

    public void validateContacts(String name) {
        String key = name.toLowerCase().trim();
        if (contacts.containsKey(key)) {
            throw new ContactAlreadyExixstException(" Contact already exists. Use update instead.");
        }
    }

    public void checkContact(String name) {
        String key = name.trim().toLowerCase();
        if (!contacts.containsKey(key)) {
            throw new ContactNotFoundException(" Contact does not exist! ");
        }
    }

    public void addContact() {
        try {
            System.out.println("-- ADD CONTACT --");
            System.out.print("Enter Name:");
            String name = sc.nextLine();
            validateContacts(name);
            System.out.print("Enter Phone number : ");
            String number = sc.nextLine();
            contacts.put(name.toLowerCase().trim(), number);
            System.out.println("details added to Contacts");
        } catch (ContactAlreadyExixstException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void deleteContact() {
        try {
            System.out.println("-- DELETE CONTACT --");
            System.out.print("Enter Name:");
            String name = sc.nextLine();
            checkContact(name.toLowerCase());
            contacts.remove(name.toLowerCase().trim());
            System.out.println("Contact removed");
        } catch (ContactNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void searchContact() {
        try {
            System.out.print("Enter Name:");
            String name = sc.nextLine();
            checkContact(name.toLowerCase());
            System.out.println("Responeses:");
            System.out.println(name + " -- " + contacts.get(name.toLowerCase().trim()));
        } catch (ContactNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts present");
        } else {
            System.out.println("--CONTACTS--");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    public void printMenu() {
        System.out.println("1. Add contact");
        System.out.println("2. Delete contact");
        System.out.println("3. Search contact");
        System.out.println("4. list contact");
        System.out.println("5. Save & Exit");

    }

    public boolean menu() {
        System.out.print("Choose: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
            switch (choice) {
                case 1 -> addContact();
                case 2 -> deleteContact();
                case 3 -> searchContact();
                case 4 -> listContacts();
                case 5 -> {
                    toSaveFile();
                    System.out.println("data saved,bye !");
                    return false;
                }
                default -> System.out.println("invalid number pick again!");

            }
        } else {
            System.out.println("invalid option !");
            return true;
        }
        return true;
    }

    // loading data into the file
    public void toSaveFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(File_NAME))) {
            /*for (String c : contacts.values()) {
                writer.println(c);
            }*/
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error saving file :" + e.getMessage());
        }
    }

    /* checks if file exists and if exists load the data inside the file */
    public void loadFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    ContactBook cb = new ContactBook(parts[0], parts[1]);
                    contacts.put(cb.getName(), cb.getPhone());
                }
            }

        } catch (IOException e) {
            System.err.println("Error opening file " + filename + ": " + e.getMessage());
        }
    }
}
