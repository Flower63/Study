package runnable.readers_writers;

/**
 * Created by Dennis
 *
 * on 12/20/2015.
 */
public class Runner {
    public static void main(String[] args) {

        Storage storage = new Storage();

        new Thread(new Writer(storage), "1st writer").start();
        new Thread(new Writer(storage), "2nd writer").start();
        new Thread(new Writer(storage), "3rd writer").start();

        new Thread(new Reader(storage)).start();
        new Thread(new Reader(storage)).start();
        new Thread(new Reader(storage)).start();
    }
}
