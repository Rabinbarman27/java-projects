package SimpleInventorySystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("      INVENTORY SYSTEM v1.0     ");
        System.out.println("================================");
        boolean getGoing = true;
        Inventory I1 = new Inventory("Pen", 12);
        Inventory I2 = new Inventory("NoteBook ", 20);
        Inventory I3 = new Inventory("Stapler", 10);
        System.out.println("Inventory loaded: " + I1.Sizee() + " items.");
        while (getGoing) {
            getGoing=I1.menu();
            System.out.println("================================");
        }
    }
}
