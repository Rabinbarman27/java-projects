import java.util.Scanner;
import java.util.Random;

public class Gussing {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean Gameon = true;

        while (Gameon) {
            sc.nextLine();  // Consume leftover newline

            int cols = 50;

            // Top border
            for (int i = 0; i < cols; i++)
                System.out.print("*");
            System.out.println();

            // Content
            System.out.println("*                GUESSING GAME                   *");
            System.out.println("*  Each player gets 5 chances to guess the word  *");
            System.out.println("*  Enter name for 2 players please               *");

            // Bottom border
            for (int i = 0; i < cols; i++)
                System.out.print("*");
            System.out.println();
            System.out.println("Enter name of player 1");
            String p1 = sc.nextLine();
            System.out.println("Enter name of player 2");
            String p2 = sc.nextLine();
            System.out.println("*===============================================*");
            System.out.println("* Player 1 is : " + p1 + "\n* Player 2 is : " + p2);
            int range=range();
            Start(p1, p2,range);
            sc.nextLine();  // Consume leftover newline
            System.out.println("DO YOU WANT TO PLAY AGAIN ? (Y/N)");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("N")) {
                Gameon = false;
             }

            }
        sc.close();
    }

    public static int RandomNumber(int range) {
        Random random = new Random();
        int randomNumber = random.nextInt(range); // generates 0-99
        System.out.println("Players need to guess numbers from '0' to '" + range + "'");

        return randomNumber;
    }
    public static int range(){

        System.out.println("Enter guess range");
        int guessRange = sc.nextInt();
        return guessRange;
    }
    public static void Start(String player1, String player2,int limit) {
        int chances = 5;
        int guess1;
        int guess2;
        //int range=RandomNumber().guessRange;
        int randomNumber = RandomNumber(limit);
        while (chances > 0) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Turn of " + player1);
                guess1 = sc.nextInt();
                if(guess1>limit){
                    System.out.println("number should be in range");
                    System.out.println("chances left : " + (chances-1));
                }
                else{
                    if (Check(guess1, player1, randomNumber)) {
                    return;
                }
                System.out.println("chances left : " + (chances-1));

                }
                
                System.out.println("Turn of " + player2);
                guess2 = sc.nextInt();
                if(guess2>limit){
                    System.out.println("number should be in range");
                    System.out.println("chances left : " + (chances-1));
                }
                else{
                if (Check(guess2, player2, randomNumber)) {
                    return;
                }
                System.out.println("chances left : " + (chances-1));
                
            }

            chances -= 1;
        }
        }
         System.out.println("both lose , the number was : "+ randomNumber);
        return;
    }

    public static boolean Check(int guess, String Player, int randomNumber) {
        if (guess == randomNumber) {
            System.out.println(Player + " wins");
            return true;
        }
        
        else if (guess > randomNumber) {
            System.err.println("Hot");
        }
        else {
            System.out.println("cold");
        }
        return false;
    }
}