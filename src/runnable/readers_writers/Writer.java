package runnable.readers_writers;

/**
 * Created by Dennis
 *
 * on 12/19/2015.
 */
public class Writer implements Runnable {

    private final Storage storage;

    public Writer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int counter = 0;

        while (true) {
            storage.store(Thread.currentThread().getName() + " record " + counter++);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
