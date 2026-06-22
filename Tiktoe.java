import java.util.Scanner;
import java.util.Arrays;

public class Tiktoe {
    static Scanner sc = new Scanner(System.in);

    public static char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };
    static String p1;
    static String p2;
    static int scoreX = 0;
    static int scoreO = 0;

    public static void main(String[] args) {
        boolean Gameon = true;

        while (Gameon) {
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
            p1 = sc.nextLine();
            System.out.print("Enter name of player 2(O):");
            p2 = sc.nextLine();
            System.out.println();

            System.out.println("============");
            System.out.println("=  SCORES  =");
            System.out.println("= " + p1 + ": " + scoreX + " =");
            System.out.println("= " + p2 + ": " + scoreO + " =");
            System.out.println("============");
            System.out.println();

            printBoard();
            char winner=start(p1, p2);
            sc.nextLine(); // Consume leftover newline

            if (winner=='X') {
                scoreX += 1;
            } else if (winner=='O') {
                scoreO += 1;
            } else {
                System.out.println("its a draw !!");
            }

            System.out.println("DO YOU WANT TO PLAY AGAIN ? (Y/N)");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("N")) {
                Gameon = false;
            } else {
                for (char[] row : board) {
                    Arrays.fill(row, ' ');
                }
            }

        }
        sc.close();
    }

    public static char[] arr = { 'A', 'B', 'C' };

    public static void printBoard() {
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

    public static Boolean checkwin(char[][] Array, char symbol) {
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

    public static boolean checkboard(char[][] Array, char symbol) {
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
    public static boolean checkrow(char[][] Array, char symbol, int row) {
        for (int col = 0; col < 3; col++) {
            if (Array[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    // CHECK COLUMS===
    public static boolean checkcolum(char[][] Array, char symbol, int col) {
        for (int row = 0; row < 3; row++) {
            if (Array[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }

    // CHECK DIAGNOLS===
    public static boolean checkdiagnoal(char[][] Array, char symbol) {
        if (Array[0][0] == symbol && Array[1][1] == symbol && Array[2][2] == symbol) {
            return true;
        }
        if (Array[0][2] == symbol && Array[1][1] == symbol && Array[2][0] == symbol) {
            return true;
        }
        return false;
    }

    // CHECKING CELLS PICKED
    public static void cellpicked(String cellName, char symbol) {
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

    public static boolean isCellEmpty(char CellName) {
        if (CellName == ' ') {
            return true;
        }
        System.out.println("cell not empty");
        return false;
    }

    public static char start(String p1, String p2) {
        String pick;
        for (int turn = 0; turn < 9; turn++) {
            if (turn % 2 == 0) { // even turns = p1
                System.out.println("Turn of " + p1);

                pick = cellinput();
                cellpicked(pick, 'X');
                printBoard();
                if (checkwin(board, 'X')) {
                    System.out.println(p1 + " wins");
                    return 'X';
                }
            } else { // odd turns = p2
                System.out.println("Turn of " + p2);
                pick = cellinput();
                cellpicked(pick, 'O');
                printBoard();
                if (checkwin(board, 'O')) {
                    System.out.println(p2 + " wins");
                    return 'O';
                }
            }
        }
        System.out.println("Its a draw!");
        return ' ';
    }

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
}
