package runnable.readers_writers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Dennis
 *
 * on 12/19/2015.
 */
public class Storage {
    private final List<String> records = new ArrayList<>();
    private final Random random = new Random();
    private int readCount;
    private final Object readSem = new Object();
    private final Semaphore access = new Semaphore(1);

    public String read() {

        String result;


        synchronized (readSem) {
            readCount++;

            if (readCount == 1) {
                access.acquireUninterruptibly();
            }
        }

        result = records.get(random.nextInt(records.size()));

        synchronized (readSem) {
            readCount--;

            if (readCount == 0) {
                access.release();
            }
        }

        return result;
    }

    public void store(String record) {
        access.acquireUninterruptibly();
        records.add(record);
        access.release();
    }
}
