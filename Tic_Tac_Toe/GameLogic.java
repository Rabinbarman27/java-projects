package Tic_Tac_Toe;

import java.util.Scanner;

/**
 * GameLogic
 */
public class GameLogic {
    static Scanner sc = new Scanner(System.in);

    public static String cellinput() {
        String input;
        do {
            System.out.println("Enter a cell name eg.(A1,A2)");
            input = sc.next();
            if (!isValidCell(input)) {
                System.out.println("Invalid cell name, try again.");
            }
        } while (!isValidCell(input));
        return input;
    }

    public static boolean isValidCell(String cell) {
        String[] validCells = { "A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3" };
        for (String v : validCells) {
            if (v.equalsIgnoreCase(cell)) {
                return true;
            }
        }
        return false;
    }

    public Boolean checkwin(char[][] Array, char symbol) {
        if (symbol == 'X') {
            if (checkboard(Array, symbol)) {
                // System.out.println(p1 + " wins");
                return true;
            }
        }
        if (symbol == 'O') {
            if (checkboard(Array, symbol)) {
                // System.out.println(p2 + " wins");
                return true;
            }
        }
        // System.out.println("Neither of the players won! its a draw");
        return false;
    }

    public boolean checkboard(char[][] Array, char symbol) {
        for (int row = 0; row < 3; row++) {
            if (checkrow(Array, symbol, row)) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (checkcolum(Array, symbol, col)) {
                return true;
            }

        }
        if (checkdiagnoal(Array, symbol)) {
            return true;
        }

        return false;
    }

    // CHECK ROWWS===
    public boolean checkrow(char[][] Array, char symbol, int row) {
        for (int col = 0; col < 3; col++) {
            if (Array[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    // CHECK COLUMS===
    public boolean checkcolum(char[][] Array, char symbol, int col) {
        for (int row = 0; row < 3; row++) {
            if (Array[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    // CHECK DIAGNOLS===
    public boolean checkdiagnoal(char[][] Array, char symbol) {
        if (Array[0][0] == symbol && Array[1][1] == symbol && Array[2][2] == symbol) {
            return true;
        }
        if (Array[0][2] == symbol && Array[1][1] == symbol && Array[2][0] == symbol) {
            return true;
        }
        return false;
    }

}