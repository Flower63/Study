package ua.epam.workers_managers.model.app;

import ua.epam.workers_managers.model.entity.Worker;
import ua.epam.workers_managers.util.DataSource;
import ua.epam.workers_managers.util.DataSourceFactory;

import java.util.*;

/**
 * Created by Dennis
 *
 * on 12/23/2015.
 */
public class Organisation {
    private static Organisation INSTANCE;
    private final Map<Integer, Worker> storage;
    private final DataSource source;
    private List<Worker> cache;
    private boolean isUpdated = true;
    private final Comparator<Worker> nameComparator = ((o1, o2) -> o1.getName().compareTo(o2.getName()));
    private final Comparator<Worker> dateComparator = ((o1, o2) -> o1.getEmploymentDate().compareTo(o2.getEmploymentDate()));
    private Comparator<Worker> current = nameComparator;

    /**
     * Constructor
     */
    private Organisation() {
        source = DataSourceFactory.getSource(DataSourceFactory.DataSourceTypes.STUB);
        storage = source.getWorkers();
    }

    public static Organisation getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Organisation();
        }
        return INSTANCE;
    }

    private void updateCache() {
        cache = new ArrayList<>(storage.values());
        cache.sort(current);
    }

    public void addWorker(Worker worker) {
        storage.put(worker.getId(), worker);
        isUpdated = true;
    }

    public void setWorker(Worker worker) {
        addWorker(worker);
    }

    public void deleteWorker(int id) {
        storage.remove(id);
        isUpdated = true;
    }

    public List<Worker> getWorkers() {
        if (isUpdated) {
            updateCache();
            isUpdated = false;
        }

        return cache;
    }

    public Worker getWorker(int id) {
        return storage.get(id);
    }

    public int getLastId() {
        TreeSet<Integer> set = (TreeSet<Integer>) storage.keySet();
        return set.last();
    }

    public void saveStorage() {
        source.storeChanges(storage);
    }

    public void sortByName() {
        current = nameComparator;
        cache.sort(current);
    }

    public void sortByDate() {
        current = dateComparator;
        cache.sort(dateComparator);
    }
}
