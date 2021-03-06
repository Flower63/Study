package ua.epam.workers_managers.controller.actions;

import ua.epam.workers_managers.model.entity.Manager;
import ua.epam.workers_managers.model.entity.Worker;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public class ActionSetManager extends Action {

    @Override
    public void execute(String[] input) {
        int id;

        try {
            id = Integer.parseInt(input[1]);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            view.incorrectInput();
            return;
        }

        Worker worker = organisation.getWorker(id);
        if (worker != null) {
            organisation.setWorker(new Manager(worker));
        }

        view.viewWorkers();
    }
}
