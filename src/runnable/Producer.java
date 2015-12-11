package runnable;

import java.util.Random;

/**
 * Created by Flower on 12/11/2015.
 */
public class Producer extends Thread {
    private Queue queue;
    private Random random = new Random();

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            queue.push(random.nextInt());
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
