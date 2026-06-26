package Vehicle_Rental_System;

import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);
    Car c1 = new Car("Honda City");
    Bike b1 = new Bike("Royal Enfield");

    public boolean menu() {
        System.out.println("--- MENU ---");
        System.out.println("1. List\r\n" + //
                "2. Rent\r\n" + //
                "3. Return\r\n" + //
                "4. Exit\r\n" //
        );
        System.out.print("Choose an option: ");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                System.out.println("--- AVAILABLE VEHICLES ---");
                for (String s : Rentable.items) {
                    System.out.println(s);
                }
                break;
            case 2:
                System.out.print("Choose vehicle to rent (1/2):");
                int rentOption = sc.nextInt();
                sc.nextLine();
                if (rentOption == 1) {
                    System.out.print("Enter number of days:");
                    int days = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Rented Honda City for" + days + " days. Total: Rs." + c1.rent(days));
                } else if (rentOption == 2) {
                    System.out.print("Enter number of days:");
                    int days = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Rented  Royal Enfield for" + days + " days. Total: Rs." + b1.rent(days));
                } else {
                    System.out.println("invalid option !");
                    menu();
                }
                break;
            case 3:
                System.out.print("Enter vehicle to return: ");
                String check = sc.nextLine();
                boolean flag = false;

                for (String n : Rentable.items) {
                    if (n.toLowerCase().contains(check.strip().toLowerCase())) {
                        flag = true;
                        boolean returned;
                        if (check.strip().equalsIgnoreCase("Honda City")) {
                            returned = c1.returnVehicle();
                        } else if(check.strip().equalsIgnoreCase("Royal Enfield")){
                            returned = b1.returnVehicle();
                        }
                        else{
                            returned=false;
                        }

                        if (returned) {
                            System.out.println(check + " returned. Thanks for renting with us!");
                        } else {
                            System.out.println(check + " was not rented out.");
                        }
                    }
                }

                if (!flag) {
                    System.out.println("Vehicle not found.");
                }

                break;
            case 4:

                return false;

            default:
                System.out.println("invalid option pick again !");
                menu();
                break;
        }
        return true;
    }
}
