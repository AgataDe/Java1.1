import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numberToGuess = new Random().nextInt(100);
        Scanner input = new Scanner(System.in);
        int numberOfTries = 0;
        boolean win = false;

        System.out.println("Please start guessing the number from 0-99. You have 5 tries :) ");
        System.out.println("Please enter your number: ");

        while (!win) {

            try {

                int playerNumber = input.nextInt();
                numberOfTries++;

                if (playerNumber == numberToGuess) {
                    win = true;
                    System.out.println("You guessed it!");
                } else if (playerNumber > numberToGuess && numberOfTries < 5) {
                    System.out.println("Your number is GREATER than the one you are trying to guess. You have " +
                            (5 - numberOfTries) + " tries left. Please try again.");
                } else if (playerNumber < numberToGuess && numberOfTries < 5) {
                    System.out.println("Your number is LOWER than the one you are trying to guess. You have " +
                            (5 - numberOfTries) + " tries left. Please try again.");
                } else {
                    System.out.println("Sorry you didn't guess the number, the answer was: " + numberToGuess);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR - this is not a number! Please try again");
                input.nextLine();
            }
        }

        input.close();
    }
}
