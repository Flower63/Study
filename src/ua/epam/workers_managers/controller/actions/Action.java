package ua.epam.workers_managers.controller.actions;

import ua.epam.workers_managers.model.app.Organisation;
import ua.epam.workers_managers.view.View;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public abstract class Action {

    protected final Organisation organisation = Organisation.getInstance();
    protected final View view = View.getInstance();

    public abstract void execute(String[] input);
}
