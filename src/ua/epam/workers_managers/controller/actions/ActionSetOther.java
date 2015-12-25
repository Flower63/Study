package ua.epam.workers_managers.controller.actions;

import ua.epam.workers_managers.model.entity.Other;
import ua.epam.workers_managers.model.entity.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dennis
 *
 * on 12/25/2015.
 */
public class ActionSetOther extends Action {

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

            Other other = new Other(worker);

            if (input.length >= 3) {
                other.setDescription(input[2]);
            }

            organisation.setWorker(other);
        }

        view.viewWorkers();
    }
}
