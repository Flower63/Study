package ua.epam.workers_managers.util;

import ua.epam.workers_managers.model.entity.Manager;
import ua.epam.workers_managers.model.entity.Other;
import ua.epam.workers_managers.model.entity.Worker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public class DataSourceStub implements DataSource {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public Map<Integer, Worker> getWorkers() {
        return new HashMap<Integer, Worker>() {{
            put(1, new Worker(1, "John Smith", LocalDate.parse("11.12.1990", formatter), LocalDate.parse("11.05.2005", formatter)));
            put(2, new Worker(2, "Gary Oldman", LocalDate.parse("10.05.1969", formatter), LocalDate.parse("30.08.2006", formatter)));
            put(3, new Worker(3, "John Lennon", LocalDate.parse("17.10.1950", formatter), LocalDate.parse("11.02.2004", formatter)));
            put(4, new Manager(4, "Elvis Presley", LocalDate.parse("11.12.1990", formatter), LocalDate.parse("11.05.2005", formatter),
                                                                    new ArrayList<Integer>(){{add(1); add(2);}}));
            put(5, new Other(5, "Mark Smith", LocalDate.parse("25.03.1990", formatter), LocalDate.parse("28.02.2007", formatter), "CEO"));
        }};
    }

    @Override
    public void storeChanges(Map<Integer, Worker> workers) {

    }
}
