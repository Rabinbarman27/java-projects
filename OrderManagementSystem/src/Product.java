public class Product {
    String productName;
    int price;
    private int quantity;

    Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return productName + " : " + price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQunatity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setQuantity(int value) {
        this.quantity = value;
    }

}
