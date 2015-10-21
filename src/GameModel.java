import java.util.Random;

/**
 * More-Less game
 *
 * @version 1.1
 *
 * @author Dennis_Zvarich
 *
 * on 10/19/2015.
 */
public class GameModel {

    /*
     * View instance
     */
    private GameView view = new GameView();

    /*
     * Controller instance
     */
    private GameController controller = new GameController();

    /*
     * Range bounds
     *
     * Will change during game, due to player's previous attempts
     */
    private int upBound = 100;
    private int lowBound = 0;

    /*
     * Statistics
     */
    private int more = 0;
    private int less = 0;
    private int attempts = 0;

    /**
     * Main method in class.
     * Perform playing with this method
     */
    public void play() {

        /*
         * Making absolutely pseudorandom prime number
         */
        int ourNumber = makeRandomNumber(upBound, lowBound);

        /*
         * Warm greeting
         */
        view.print("Greetings! Let's play a game");
        view.print("I think about a number, somewhere between 0 and 100");
        view.print("Try to guess it!");

        /*
         * Game loop
         *
         * Breaks when player guessed right
         */
        while (true) {
            view.print("Current range: < " + lowBound + " ... " + upBound + " >");

            int enteredNumber = controller.getInputValue();

            if(isOurNumber(ourNumber, enteredNumber)) {
                break;
            }
        }

        /*
         * Celebration
         */
        view.print("Seems that you succeed this time");
        showStatistics();
    }

    /*
     * Outputs your phenomenal statistics
     */
    private void showStatistics() {
        view.print("You did it from the " + attempts + " try");
        view.print(more + " more and " + less + " less");
    }

    /**
     * Generates pseudorandom value, exclusive specified bounds
     *
     * @param low lower bound
     * @param up  upper bound
     * @return random number within specified bounds, exclusive
     */
    public int makeRandomNumber(int up, int low) {
        Random random = new Random();
        return random.nextInt(up - low - 1) + low + 1;
    }

    /*
     * Checks our number and entered number for equality.
     * In case of match returns true (which breaks game loop
     * and notify about wining)
     *
     * Or return false, notify player and change range bounds otherwise
     */
    public boolean isOurNumber(int ourNumber, int enteredNumber) {

        if (enteredNumber <= lowBound || enteredNumber >= upBound) {
            view.print("Enter numbers only within specified bounds, please!");
            return false;           //We don't count this input as a try, because it's incorrect
        }

        if (enteredNumber == ourNumber) {
            attempts++;
            return true;                          //We did it, Yay!
        } else if (enteredNumber > ourNumber) {
            view.print("Too much. My number is less, try again");
            upBound = enteredNumber;
            attempts++;
            more++;
        } else if (enteredNumber < ourNumber) {
            view.print("Too few. My number is bigger, try again");
            lowBound = enteredNumber;
            attempts++;
            less++;
        }

        return false;
    }
}
