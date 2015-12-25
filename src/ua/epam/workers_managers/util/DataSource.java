package ua.epam.workers_managers.util;

import ua.epam.workers_managers.model.entity.Worker;

import java.util.Map;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public interface DataSource {

    Map<Integer, Worker> getWorkers();

    void storeChanges(Map<Integer, Worker> workers);
}
