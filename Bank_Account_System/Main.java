package Bank_Account_System;

import java.util.Scanner;

public class Main {
    static String Name;
    static double balance;
    boolean session = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("    BANK ACCOUNT SYSTEM v1.0    ");
        System.out.println("================================");
        System.out.print("Enter account holder name: ");
        Name = sc.nextLine();
        System.out.print("Enter starting balance: ");
        balance = sc.nextDouble();
        BankAccount A1 = new BankAccount(Name, balance);
        A1.greet();
        System.out.println("");
        boolean session = true;
        while (session) {
            session=A1.menu();
        }
    }
}
