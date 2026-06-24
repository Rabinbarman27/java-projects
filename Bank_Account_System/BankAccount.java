package Bank_Account_System;
import java.util.Scanner;
import java.util.ArrayList;;

public class BankAccount {
    private String holderName;
    private double Balance;
    static Scanner sc = new Scanner(System.in);
    ArrayList<String> transactions = new ArrayList<>();

    public BankAccount(String holderName, double Balance) {
        this.holderName = holderName;
        this.Balance = Balance;
    }

    // Greet the user
    public void greet() {
        System.out.println("Account created! Welcome, " + holderName);
    }

    // Deposit
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.println("invalid amount");
        } else {
            Balance += amount;
            transactions.add("Creddited : " + amount);
            System.out.println("Deposited " + amount + "  New balance:" + Balance);
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Withdrawal failed: insufficient balance. Current balance: " + Balance);
        } else {
            Balance += amount;
            transactions.add("withdrawed : " + amount);
            System.out.println("$ " + amount + " Debited from your account!,  New balance: " + Balance);
        }
    }

    // Check Balance
    public Double Checkbalance() {
        return Balance;
    }

    // display Menu function
    public boolean menu() {
        int option;
        int amount;
        System.out.println("--- MENU --");
        System.out.println("1. Deposit\r\n" + //
                "2. Withdraw\r\n" + //
                "3. Check Balance\r\n" + //
                "4. Mini-statement\r\n" + //
                "5. Exit");
        System.out.print("Choose an option: ");
        option = sc.nextInt();
        sc.nextLine();
        switch (option) {
            case 1:
                System.out.print("Enter amount to deposit: ");
                amount = sc.nextInt();
                deposit(amount);
                break;

            case 2:
                System.out.print("Enter amount to withdraw:  ");
                amount = sc.nextInt();
                withdraw(amount);
                break;

            case 3:
                System.out.print("Current Balance in your account:  " + Checkbalance());
                break;

            case 4:
                System.out.println("--- MINI STATEMENT ---");
                for (String s : transactions) {
                    System.out.println(s);
                }
                break;

            case 5:

                return false;

            default:
                break;
        }
        return true;
    }
}
