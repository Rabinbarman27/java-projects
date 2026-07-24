import java.util.*;
import java.io.*;

public class Inventory {
    private HashMap<String, Product> products = new HashMap<>();
    private ArrayList<Order> orders = new ArrayList<>();
    static final String PRODUCT_FILE_NAME = "products.csv";
    static final String ORDERS_FILE_NAME = "orders.csv";
    Scanner sc = new Scanner(System.in);

    public void toSaveOrdersFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ORDERS_FILE_NAME))) {
            for (int i = 0; i < orders.size(); i++) {
                writer.println(orders.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error saving file :" + e.getMessage());

        }
    }

    public void toSaveProductFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PRODUCT_FILE_NAME))) {
            for (Map.Entry<String, Product> entry : products.entrySet()) {
                writer.println(entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error saving file :" + e.getMessage());

        }

    }

    public void loadOrders(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 4) {
                    Order or = new Order(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), parts[3]);
                    orders.add(or);

                }
            }
        } catch (IOException e) {
            System.out.println("Error opening File" + fileName + e.getCause());
        }
    }

    public void loadProducts(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                if (parts.length == 3) {
                    Product pr = new Product(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    products.put(pr.getProductName(), pr);

                }
            }
        } catch (IOException e) {
            System.out.println("Error opening File" + fileName + e.getCause());
        }
    }
}
