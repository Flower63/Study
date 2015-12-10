package ua.epam.selection_committee;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dennis
 *
 * on 12/10/2015.
 */
public class WaitingRoom {

    private Queue<Student> queue = new LinkedList<>();

    private boolean isDone = false;

    /**
     * Getting student from queue head
     *
     * @return Student
     */
    public synchronized Student getStudent() {

        if (queue.size() <= 25 && !isDone) {
            notify();

            while (queue.size() < 50 && !isDone) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return queue.poll();
    }

    /**
     * Adding student to queue tail
     *
     * @param student New student
     */
    public synchronized void addStudent(Student student) {

        if (queue.size() >= 50) {
            notify();

            while (queue.size() > 25) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        queue.offer(student);
    }

    /**
     * Look at next student
     *
     * @return Student
     */
    public synchronized Student peek() {

        while (queue.isEmpty() && !isDone) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return queue.peek();
    }

    /**
     * Generator exhausted notification
     */
    public synchronized void setDone() {
        isDone = true;
        notify();
    }
}
