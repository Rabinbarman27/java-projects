package SimpleInventorySystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    String item;
    int quantity;
    static Scanner sc = new Scanner(System.in);

    Inventory(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        try {
            validateItemsToAdd(item, quantity);
        } catch (DuplicateItemException e) {
            System.err.println("Error "+e.getMessage());
        }
    }

    private static HashMap<String, Integer> inventory = new HashMap<>();

    public void addItem() {
        System.out.print("Enter item name : ");
        String item = sc.nextLine().toLowerCase();
        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();
        sc.nextLine();
        try {
            validateItemsToAdd(item, quantity);
        } catch (DuplicateItemException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void sellItem() {
        System.out.print("Enter item name : ");
        String item = sc.nextLine();
        System.out.print("Enter Quantity required : ");
        int quantity = sc.nextInt();
        sc.nextLine();
        try {
            validateItemsToSell(item.toLowerCase(), quantity);
        } catch (OutOfStockException e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    public void restockItem() {
        System.out.print("Enter item name : ");
        String item = sc.nextLine();
        System.out.print("Enter Quantity added : ");
        int quantity = sc.nextInt();
        sc.nextLine();
        try {
            validateItemsToRestock(item.toLowerCase(), quantity);
        } catch (ItemNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void viewInventory() {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }

    public String item() {
        return item;
    }

    public int quantity() {
        return quantity;
    }

    public int Sizee() {
        return inventory.size();
    }

    public void validateItemsToAdd(String item, int quantity) {
        if (inventory.containsKey(item)) {
            throw new DuplicateItemException(item + " already in inventory");
        } else {
            inventory.put(item.toLowerCase(), quantity);
        }
    }

    public void validateItemsToSell(String item, int quantity) {
        if (!inventory.containsKey(item)) {
            throw new ItemNotFoundException(item + " not found in the inventory");
        }
        if (quantity > inventory.get(item)) {
            throw new OutOfStockException("Error : Only "
                    + quantity + " '" + item + "' in Stock. Cannot sell ");
        }
        int current = inventory.get(item);
        inventory.put(item.toLowerCase(), current - quantity);
        System.out.println("Sold " + quantity + "X " + item + ".Remaining: " + (current - quantity));
    }

    public void validateItemsToRestock(String item, int quantity) {
        if (!inventory.containsKey(item)) {
            throw new ItemNotFoundException(item + " not found in the inventory");

        }
        int current = inventory.get(item);
        inventory.put(item.toLowerCase(), current + quantity);
        System.out.println(
                current + "X " + item + " has been added to the inventory. total count : " + (current + quantity));
    }

    public boolean menu() {
        System.out.println("1.Add\r\n" +
                "2.Restock\r\n" +
                "3.Sell \r\n" + "4.View \r\n" +
                "5.Exit");
        System.out.print("Choose : ");
        int choose = sc.nextInt();
        System.out.println("================================");
        sc.nextLine();
        switch (choose) {
            case 1:
                addItem();
                break;
            case 2:
                restockItem();
                break;
            case 3:
                sellItem();
                break;
            case 4:
                viewInventory();
                break;
            case 5:
                return false;
            default:
                System.out.println("invalid input");
                break;
        }
        return true;
    }
}
