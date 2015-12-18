package runnable.visitor;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dennis
 *
 * on 12/18/2015.
 */
public class University implements Runnable {

    private final Random random = new Random();
    private final int randThreshold = 5;
    private List<Student> students = new LinkedList<>();
    private boolean isOver = false;
    private StudentQueue queue;

    /**
     * Visitor instance
     */
    private final Visitor visitor = q -> {

        int randNum = random.nextInt(randThreshold) + 1;

        while (!q.isEmpty() && randNum > 0) {
            randNum--;
            students.add(q.poll());
        }

        if (q.isEmpty()) {
            setOver();
        }
    };

    public University(StudentQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isOver) {
            queue.enrollStudents(visitor);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(students.size() + " University students:");
        System.out.println(students);
    }


    private void setOver() {
        isOver = true;
    }
}
