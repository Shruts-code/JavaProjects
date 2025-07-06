import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static void main(String[]args){
        Scanner Numberguess = new Scanner(System.in);
        Random random = new Random();

        String PlayAgain;
        
        System.out.println("Welcome to the number guessing game!");

        do{
            int NumberToGuess = random.nextInt(101);
            int attempts = 0;
            int guess;

            System.out.println("I have choose my number between 1 to 100, Try to guess it");

            do{
                System.out.println("Enter your guess:");
                guess = Numberguess.nextInt();
                attempts++;

                if (guess < NumberToGuess){
                    System.out.println("Too Low! TRY AGAIN.");
                }else if (guess > NumberToGuess){
                    System.out.println("Too High! TRY AGAIN.");
                }else{
                    System.out.println("Congratulation! You have guesses the number in " + attempts + " attempts.");
                }
            } while (guess != NumberToGuess);

            Numberguess.nextLine();
            System.out.println("Do you want to play again? (YES/NO): ");
            PlayAgain = Numberguess.nextLine();

        } while(PlayAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!!");
        Numberguess.close();
    }
    
}
