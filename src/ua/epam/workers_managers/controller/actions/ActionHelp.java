package ua.epam.workers_managers.controller.actions;

/**
 * Created by Dennis
 *
 * on 12/25/2015.
 */
public class ActionHelp extends Action {

    @Override
    public void execute(String[] input) {
        view.showHelp();
    }
}
