package MiniContactBook;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================\r\n" +
                "        CONTACT BOOK v1.0\r\n" +
                "================================\r\n");
        boolean isRunning = true;
        ContactBook b1 = new ContactBook();
        b1.loadFile("contacts.txt");
        while (isRunning) {
            b1.printMenu();
            isRunning = b1.menu();
        }
    }
}
