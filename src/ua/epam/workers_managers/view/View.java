package ua.epam.workers_managers.view;

import ua.epam.workers_managers.model.app.Organisation;
import ua.epam.workers_managers.model.entity.Manager;
import ua.epam.workers_managers.model.entity.Other;
import ua.epam.workers_managers.model.entity.Worker;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public class View {

    private final Organisation organisation = Organisation.getInstance();
    private final static View INSTANCE = new View();

    /**
     * Constructor
     */
    private View() {}

    public static View getInstance() {
        return INSTANCE;
    }

    public void viewWorkers() {
        for (Worker worker : organisation.getWorkers()) {
            StringBuilder sb = new StringBuilder();
            sb.append(worker.getId());
            sb.append(" ");
            sb.append(worker.getName());
            sb.append(" ");
            sb.append(worker.getBirthDate());
            sb.append(" ");
            sb.append(worker.getEmploymentDate());

            if (worker instanceof Other) {
                Other other = (Other) worker;

                sb.append(" ");
                sb.append(other.getDescription());
            } else if (worker instanceof Manager) {
                Manager manager = (Manager) worker;

                sb.append(" ");
                sb.append("manager");
                sb.append("\n");

                for (int id : manager.getWorkers()) {
                    sb.append("    ");
                    Worker w = organisation.getWorker(id);

                    if (w != null) {
                        sb.append(w.getName());
                        sb.append("\n");
                    }
                }
            }

            System.out.println(sb.toString());
        }
    }

    public void showHelp() {
        System.out.println("available commands:\n\n" +
                            "fire <id>\n" +
                            "set_manager <id>\n" +
                            "set_worker <id>\n" +
                            "set_other <id> <description>\n" +
                            "attach_to_manager <worker_id> <manager_id>\n" +
                            "detach_from_manager <worker_id> <manager_id>\n" +
                            "sort_by_name\n" +
                            "sort_by_date\n" +
                            "exit\n");
    }

    public void incorrectInput() {
        System.out.println("Incorrect input");
    }
}
