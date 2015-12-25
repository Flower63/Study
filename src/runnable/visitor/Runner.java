package runnable.visitor;

/**
 * Created by Dennis
 *
 * on 12/18/2015.
 */
public class Runner {
    public static void main(String[] args) {
        StudentQueue queue = new StudentQueue();

        MathInstitute math = new MathInstitute(queue);
        BioInstitute bio = new BioInstitute(queue);
        University uni = new University(queue);
        Generator generator = new Generator(queue);

        new Thread(generator).start();

        new Thread(bio).start();
        new Thread(uni).start();
        new Thread(math).start();
    }
}
