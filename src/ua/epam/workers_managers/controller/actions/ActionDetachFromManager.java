package ua.epam.workers_managers.controller.actions;

import ua.epam.workers_managers.model.entity.Manager;
import ua.epam.workers_managers.model.entity.Worker;

/**
 * Created by Dennis
 *
 * on 12/25/2015.
 */
public class ActionDetachFromManager extends Action {

    @Override
    public void execute(String[] input) {
        int workerId;
        int managerId;

        try {
            workerId = Integer.parseInt(input[1]);
            managerId = Integer.parseInt(input[2]);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            view.incorrectInput();
            return;
        }

        Worker worker = organisation.getWorker(workerId);
        Worker manager = organisation.getWorker(managerId);

        if (worker == null || manager == null || !(manager instanceof Manager)) {
            view.incorrectInput();
            return;
        }

        Manager m = (Manager) manager;

        m.getWorkers().remove(new Integer(workerId));

        view.viewWorkers();
    }
}
