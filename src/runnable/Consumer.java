package runnable;

/**
 * Created by Flower on 12/11/2015.
 */
public class Consumer extends Thread {

    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            Integer integer = queue.pop();

            System.out.println(integer);

            try {
                sleep(8);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
