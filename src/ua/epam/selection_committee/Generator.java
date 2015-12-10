package ua.epam.selection_committee;

import java.util.Random;

/**
 * Created by Dennis
 *
 * on 12/10/2015.
 */
public class Generator implements Runnable {

    private WaitingRoom room;
    private int biologists = 200;
    private int mathematicians = 250;
    private Random random = new Random();

    public Generator(WaitingRoom room) {
        this.room = room;
    }

    @Override
    public void run() {
        while (biologists > 0 || mathematicians > 0) {
            if (mathematicians == 0) {
                room.addStudent(new Biologist());
                biologists--;
            } else if (biologists == 0) {
                room.addStudent(new Mathematician());
                mathematicians--;
            } else {
                switch (random.nextInt(2)) {
                    case 0:
                        room.addStudent(new Biologist());
                        biologists--;
                        break;
                    case 1:
                        room.addStudent(new Mathematician());
                        mathematicians--;
                        break;
                }
            }
        }

        room.setDone();
    }
}
