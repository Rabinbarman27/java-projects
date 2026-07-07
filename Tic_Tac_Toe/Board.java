package Tic_Tac_Toe;

import java.util.Random;
import java.util.Scanner;

public class Board {
    static Scanner sc = new Scanner(System.in);
    GameLogic g = new GameLogic();

    String p1, p2;

    Board(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    public static char[] arr = { 'A', 'B', 'C' };

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" +---+---+---+");

            System.out.print(arr[i] + "| ");
            for (int j = 0; j < 3; j++) {

                System.out.print(board[i][j] + " | ");

            }

            System.out.println();

        }
        System.out.println(" +---+---+---+");

    }

    public boolean isCellEmpty(char CellName) {
        if (CellName == ' ') {
            return true;
        }
        System.out.println("cell not empty");
        return false;
    }

    public char start(String p1, String p2) {
        String pick;
        for (int turn = 0; turn < 9; turn++) {
            if (turn % 2 == 0) { // even turns = p1
                System.out.println("Turn of " + p1);

                pick = cellinput();
                cellpicked(pick, 'X');
                printBoard();
                if (g.checkwin(board, 'X')) {
                    System.out.println(p1 + " wins");
                    return 'X';
                }
            } else { // odd turns = p2
                System.out.println("Turn of " + p2);
                pick = randomcell();
                System.out.println(p2 + " (computer) picks " + pick);
                cellpicked(pick, 'O');
                printBoard();
                if (g.checkwin(board, 'O')) {
                    System.out.println(p2 + " wins");
                    return 'O';
                }
            }
        }
        System.out.println("Its a draw!");
        return ' ';
    }

    public String cellinput() {
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

    public boolean isValidCell(String cell) {
        String[] validCells = { "A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3" };
        for (String v : validCells) {
            if (v.equalsIgnoreCase(cell)) {
                return true;
            }
        }
        return false;
    }

    public void cellpicked(String cellName, char symbol) {
        String pick;
        switch (cellName) {
            case "A1": // double quotes
                if (!isCellEmpty(board[0][0])) {
                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {
                    board[0][0] = symbol;
                }
                break;
            case "A2":
                if (!isCellEmpty(board[0][1])) {
                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();

                } else {
                    board[0][1] = symbol;
                }
                break;
            case "A3":
                if (!isCellEmpty(board[0][2])) {

                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {
                    board[0][2] = symbol;
                }
                break;
            case "B1":
                if (!isCellEmpty(board[1][0])) {
                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {
                    board[1][0] = symbol;
                }
                break;
            case "B2":
                if (!isCellEmpty(board[1][1])) {

                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {
                    board[1][1] = symbol;
                }
                break;
            case "B3":
                if (!isCellEmpty(board[1][2])) {
                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {

                    board[1][2] = symbol;
                }
                break;
            case "C1":
                if (!isCellEmpty(board[2][0])) {

                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {
                    board[2][0] = symbol;
                }
                break;
            case "C2":
                if (!isCellEmpty(board[2][1])) {
                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {

                    board[2][1] = symbol;
                }
                break;
            case "C3":
                if (!isCellEmpty(board[2][2])) {
                    pick = cellinput();
                    cellpicked(pick, symbol);
                    printBoard();
                } else {
                    board[2][2] = symbol;
                }
                break;
            default:
                System.out.println("Invalid cell name");
                break;
        }

    }

    public String randomcell() {
        Random rand = new Random();
        String[] allcells = { "A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3" };
        int[] row = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
        int[] col = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
        int index;
        do {
            index = rand.nextInt(9);
        } while (board[row[index]][col[index]] != ' ');

        return allcells[index];
    }

}
