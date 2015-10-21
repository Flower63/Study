import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * More-Less game
 *
 * @version 1.1
 *
 * @author Dennis_Zvarich
 *
 * on 10/19/2015.
 */
public class GameController {
    /*
     * Reader instance
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /*
     * View instance
     */
    private GameView view = new GameView();

    /**
     * Method to retrieve numeric value, entered by user
     *
     * @return entered numeric value
     */
    public int getInputValue() {
        String input = null;
        int enteredNumber = 0;
        boolean exceptionOccured;

        /*
         * Will cycling until correct (number) input or keyword "exit" is entered
         */
        do {
            try {
                input = reader.readLine();

                enteredNumber = Integer.parseInt(input);

                exceptionOccured = false;

            } catch (NumberFormatException e) {

                if ("exit".equals(input)) {

                    /* Looks like somebody wanna quit */
                    System.exit(0);
                }

                view.print("Enter only numbers, please");
                exceptionOccured = true;

            } catch (IOException e) {

                view.print("Something goes wrong...");
                exceptionOccured = true;
            }
        } while (exceptionOccured);

        return enteredNumber;
    }
}
