import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Dennis on 10/17/2015.
 */
public class MoreLessGame {
    private int upLimit = 100;
    private int lowLimit = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("...Greetings...");

        Thread.sleep(1000);

        System.out.println("...and welcome...");

        Thread.sleep(2000);

        System.out.println("I want to play a game");

        Thread.sleep(2000);

        System.out.println("I think about a number, somewhere between 0 and 100");

        Thread.sleep(2000);

        System.out.println("Try to guess it...");

        Thread.sleep(2000);

        new MoreLessGame().play();
    }

    void play() throws IOException, InterruptedException {
        String input;
        int enteredNumber;
        int attempts = 0;
        int more = 0;
        int less = 0;
        int randomNumber = rand(lowLimit, upLimit);
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("current range: < " + lowLimit + " ... " + upLimit + " >");

            input = reader.readLine();

            try {
                enteredNumber = Integer.parseInt(input);
            } catch (NumberFormatException n) {
                System.out.println("Enter only numbers, please!");
                continue;
            }

            if (enteredNumber < lowLimit || enteredNumber > upLimit) {
                System.out.println("Please, enter number within defined scope");
                continue;
            }

            if (enteredNumber == randomNumber) {
                attempts++;
                inputs.add(enteredNumber);
                break;
            } else {
                if (enteredNumber < randomNumber) {
                    System.out.println("My number is bigger. Try again");
                    lowLimit = enteredNumber;
                    inputs.add(enteredNumber);
                    less++;
                    attempts++;
                } else if (enteredNumber > randomNumber) {
                    System.out.println("My number is less. Try again");
                    upLimit = enteredNumber;
                    inputs.add(enteredNumber);
                    more++;
                    attempts++;
                }
            }
        }

        Thread.sleep(1000);

        System.out.println("...Well well well, it seems that you have succeed this time...");

        Thread.sleep(3000);

        System.out.println("you made it from the " + attempts + " try");
        System.out.println(more + " more and " + less + " less");
        System.out.println("\nYou tried this numbers:");
        for (Integer i : inputs) {
            System.out.print(i + " ");
        }
    }

    public int rand(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + min) + min;
    }
}
