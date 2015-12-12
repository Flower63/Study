package ua.epam.selection_committee;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dennis
 *
 * on 12/10/2015.
 */
public class WaitingRoom {

    /**
     * Queue of students
     */
    private Queue<Student> queue = new LinkedList<>();

    /**
     * Variable to exit process
     */
    private boolean isDone = false;

    /**
     * Limits
     */
    private final int upperLimit = 50;
    private final int lowerLimit = 25;

    /**
     * Getting student from queue head
     *
     * @return Student
     */
    public synchronized Student getStudent() {

        if (queue.size() <= lowerLimit && !isDone) {
            notifyAll();

            while (queue.size() < upperLimit && !isDone) {
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

        if (queue.size() >= upperLimit) {
            notifyAll();

            while (queue.size() > lowerLimit) {
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
     * Generator exhausted notification
     */
    public synchronized void setDone() {
        isDone = true;
        notifyAll();
    }
}
