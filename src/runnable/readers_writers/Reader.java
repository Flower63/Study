package runnable.readers_writers;

/**
 * Created by Dennis
 *
 * on 12/19/2015.
 */
public class Reader implements Runnable {
    private final Storage storage;

    public Reader(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            String record = storage.read();
            System.out.println("Reader read: " + record);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
