package Vehicle_Rental_System;

import java.util.ArrayList;

interface Rentable {
    public double rent(int days);

    public Boolean returnVehicle();

    public static ArrayList<String> items = new ArrayList<>();
    
}
