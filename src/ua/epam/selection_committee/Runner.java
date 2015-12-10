package ua.epam.selection_committee;

/**
 * Created by Dennis
 *
 * on 12/10/2015.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {

        WaitingRoom room = new WaitingRoom();

        Generator generator = new Generator(room);
        Committee committee = new Committee(room);

        Thread gen = new Thread(generator);
        Thread comm = new Thread(committee);

        gen.start();
        comm.start();
    }
}
