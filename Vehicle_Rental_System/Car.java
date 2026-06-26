package Vehicle_Rental_System;

public class Car implements Rentable {
    String car;
    private double price = 1500;
    static boolean Available;

    Car(String car) {
        this(car, 1500);
    }

    Car(String car, double price) {
        this.car = car;
        this.price = price;
        Available = false;

        items.add("1. Car      - " + car + "     (Rs." + price + "/day)");

    }

    @Override
    public double rent(int days) {
        double total = days * 1500;

        return total;
    }

    @Override
    public Boolean returnVehicle() {
        Available = true;
        return Available;
    }

    public double getprice() {
        return price;
    }

}
