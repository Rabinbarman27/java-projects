package Tic_Tac_Toe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean gameon = true;
        sc.nextLine(); // Consume leftover newline

        int cols = 50;

        // Top border
        for (int i = 0; i < cols; i++)
            System.out.print("*");
        System.out.println();

        // Content
        System.out.println("*                Tik-Tak-Toe                     *");
        System.out.println("*      first player to aline 3 symbols wins!     *");
        for (int i = 0; i < cols; i++)
            System.out.print("*");
        System.out.println();

        System.out.print("Enter name of player 1(X):");
        String p1 = sc.nextLine();
        System.out.print("Enter name of player 2(O):");
        String p2 = sc.nextLine();
        System.out.println();
        Board b1 = new Board(p1, p2);
        Scoreboard s1 = new Scoreboard();
        b1.printBoard();

        while (gameon) {
            System.out.println("============");
            System.out.println("=  SCORES  =");
            System.out.println("= " + p1 + ": " + s1.viewWinsX() + " =");
            System.out.println("= " + p2 + ": " + s1.viewWinsO() + " =");
            System.out.println("============");
            System.out.println();
            char winner = b1.start(p1, p2);
            sc.nextLine(); // Consume leftover newline

            if (winner == 'X') {
                s1.addWinX();
            } else if (winner == 'O') {
                s1.addWinO();
            } else {
                System.out.println("its a draw !!");
            }

            System.out.println("DO YOU WANT TO PLAY AGAIN ? (Y/N)");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("N")) {
                gameon = false;
            } else {
                for (char[] row : b1.board) {
                    Arrays.fill(row, ' ');
                }
            }

        }
        sc.close();
    }
}
