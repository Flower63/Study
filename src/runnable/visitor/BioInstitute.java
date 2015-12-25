package runnable.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dennis
 *
 * on 12/18/2015.
 */
public class BioInstitute implements Runnable {

    private boolean isOver = false;
    private List<Student> students = new LinkedList<>();
    private StudentQueue queue;

    /**
     * Visitor instance
     */
    private final Visitor visitor = q -> {

        while (q.peek() instanceof Biologist) {
            students.add(q.poll());
        }

        if (q.isEmpty()) {
            setOver();
        }
    };

    public BioInstitute(StudentQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isOver) {
            queue.enrollStudents(visitor);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(students.size() + " Bio students:");
        System.out.println(students);
    }


    private void setOver() {
        isOver = true;
    }
}
