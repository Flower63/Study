package ua.epam.workers_managers.model.entity;

import java.time.LocalDate;

/**
 * Created by Dennis
 *
 * on 12/22/2015.
 */
public class Worker {
    protected int id;
    protected String name;
    protected LocalDate birthDate;
    protected LocalDate employmentDate;

    public int getId() {
        return id;
    }

    public Worker(Worker worker) {
        this.id = worker.getId();
        this.name = worker.getName();
        this.birthDate = worker.getBirthDate();
        this.employmentDate = worker.getEmploymentDate();
    }

    public Worker(int id, String name, LocalDate birthDate, LocalDate employmentDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
    }

    public Worker() {}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }
}
