package Vehicle_Rental_System;

public class Bike implements Rentable {
    String bike;
    private boolean Available;
    private double price = 500;
    Bike(String bike){
        this(bike,500);
    }

    Bike(String bike,double price) {
        this.bike = bike;
        this.price=price;
        Available = false;
        items.add("2. Bike    - " + bike + "     (Rs." + price + "/day)");
    }

    @Override
    public double rent(int days) {
        double total = days * price;
        return total;
    }

    @Override
    public Boolean returnVehicle() {
        Available = true;
        return  Available;
    }

    public double getprice(){
        return price;
    }

}
