package ua.epam.workers_managers;

import ua.epam.workers_managers.controller.CommandDispatcher;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public class Runner {
    public static void main(String[] args) {
        CommandDispatcher dispatcher = new CommandDispatcher();
        dispatcher.run();
    }
}
