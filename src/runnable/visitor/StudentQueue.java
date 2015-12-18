package runnable.visitor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dennis
 *
 * on 12/18/2015.
 */
public class StudentQueue {
    private volatile Queue<Student> queue = new LinkedList<>();
    private final int lowLimit = 25;
    private final int upLimit = 50;
    private volatile boolean done = false;

    public synchronized void put(Student student) {

        if (queue.size() >= upLimit) {
            notifyAll();

            while (queue.size() > lowLimit) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        queue.offer(student);
    }

    public synchronized void enrollStudents(Visitor visitor) {

        if (queue.size() <= lowLimit && !done) {
            notifyAll();

            while (queue.size() < upLimit && !done) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        visitor.enroll(queue);
    }

    public synchronized void setDone() {
        done = true;
        notifyAll();
    }
}
