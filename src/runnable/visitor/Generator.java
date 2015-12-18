package runnable.visitor;

import java.util.Random;

/**
 * Created by Dennis
 *
 * on 12/10/2015.
 */
public class Generator implements Runnable {

    private StudentQueue queue;
    private int biologists = 200;
    private int mathematicians = 250;
    private Random random = new Random();
    private Student biologist = new Biologist();
    private Student mathematician = new Mathematician();

    public Generator(StudentQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (biologists > 0 || mathematicians > 0) {
            if (mathematicians == 0) {
                queue.put(biologist);
                biologists--;
            } else if (biologists == 0) {
                queue.put(mathematician);
                mathematicians--;
            } else {
                switch (random.nextInt(2)) {
                    case 0:
                        queue.put(biologist);
                        biologists--;
                        break;
                    case 1:
                        queue.put(mathematician);
                        mathematicians--;
                        break;
                }
            }
        }

        queue.setDone();
    }
}
