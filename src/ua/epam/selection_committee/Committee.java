package ua.epam.selection_committee;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dennis
 *
 * on 12/10/2015.
 */
public class Committee implements Runnable {

    private WaitingRoom room;

    private Random random = new Random();

    private boolean isDone = false;

    private List<Student> biologists = new LinkedList<>();
    private List<Student> mathematicians = new LinkedList<>();
    private List<Student> all = new LinkedList<>();

    public Committee(WaitingRoom room) {
        this.room = room;
    }

    @Override
    public void run() {
        while (!isDone) {
            /*
             * Getting biologists students
             */
            while (room.peek() instanceof Biologist) {
                biologists.add(room.getStudent());
            }

            /*
             * Getting all students
             */
            for (int i = 0; i < getStudentsNumber(); i++) {
                Student student = room.getStudent();

                if (student != null) {
                    all.add(student);
                } else {
                    isDone = true;
                    break;
                }
            }

            /*
             * Getting mathematicians students
             */
            while (room.peek() instanceof Mathematician) {
                mathematicians.add(room.getStudent());
            }
        }

        showLists();
    }

    /**
     * Getting number fo students to enroll
     *
     * @return Random number from 1 to 5
     */
    private int getStudentsNumber() {
        return random.nextInt(5) + 1;
    }

    /**
     * Showing output lists of students
     */
    private void showLists() {
        System.out.println(biologists.size());
        System.out.println(all.size());
        System.out.println(mathematicians.size());

        System.out.println();

        System.out.println(biologists);
        System.out.println(all);
        System.out.println(mathematicians);
    }
}
