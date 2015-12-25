package ua.epam.workers_managers.model.entity;

import java.time.LocalDate;

/**
 * Created by Dennis
 *
 * on 12/22/2015.
 */
public class Other extends Worker {
    private String description;

    public Other(int id, String name, LocalDate birthDate, LocalDate employmentDate, String description) {
        super(id, name, birthDate, employmentDate);
        this.description = description;
    }

    public Other(Worker worker) {
        super(worker);
        this.description = "no description";
    }

    public Other() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
