public class Order {
    int orderId;
    String productName;
    int quantityOrdered;
    int totalAmount;
    String date;

    Order(String productName, int quantityOrdered, int totalAmount, String date) {
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
        this.totalAmount = totalAmount;
        this.date = date;
    }
    
}
