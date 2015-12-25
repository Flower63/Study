package ua.epam.workers_managers.controller.actions;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public class ActionFire extends Action {

    @Override
    public void execute(String[] input) {

        int id;

        try {
            id = Integer.parseInt(input[1]);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            view.incorrectInput();
            return;
        }

        organisation.deleteWorker(id);

        view.viewWorkers();
    }
}
