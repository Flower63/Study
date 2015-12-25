package ua.epam.workers_managers.controller;

import ua.epam.workers_managers.controller.actions.Action;
import ua.epam.workers_managers.controller.actions.ActionFactory;
import ua.epam.workers_managers.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public class CommandDispatcher {
    private final ActionFactory factory = ActionFactory.getInstance();
    private final View view = View.getInstance();

    public void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            view.viewWorkers();

            while (true) {
                String input = reader.readLine();

                if ("exit".equals(input)) {
                    factory.getAction(input).execute(null);
                    return;
                }

                String[] commands = input.split(" ");

                String command = commands[0];

                Action action = factory.getAction(command);

                if (action != null) {
                    action.execute(commands);
                } else {
                    view.incorrectInput();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
