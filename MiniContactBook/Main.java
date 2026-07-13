package MiniContactBook;

public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        ContactBook b1 = new ContactBook("Rabin", "1234567891");
        b1.loadFile("contacts.txt");
        while (isRunning) {
            b1.printMenu();
            isRunning = b1.menu();
        }
    }
}
