package ua.epam.workers_managers.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dennis
 *
 * on 12/22/2015.
 */
public class Manager extends Worker {
    private List<Integer> workers;

    public Manager(int id, String name, LocalDate birthDate, LocalDate employmentDate, List<Integer> workers) {
        super(id, name, birthDate, employmentDate);
        this.workers = workers;
    }

    public Manager(Worker worker) {
        super(worker);
        this.workers = new ArrayList<>();
    }

    public List<Integer> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Integer> workers) {
        this.workers = workers;
    }
}
