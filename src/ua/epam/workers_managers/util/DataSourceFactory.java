package ua.epam.workers_managers.util;

/**
 * Created by Dennis
 *
 * on 12/24/2015.
 */
public abstract class DataSourceFactory {

    public static DataSource getSource(DataSourceTypes type) {
        switch (type) {
            case STUB:
                return new DataSourceStub();
            default:
                return null;
        }
    }

    public enum DataSourceTypes {
        STUB
    }
}
