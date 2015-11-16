package streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

/**
 * Created by Flower on 11/16/2015.
 */
public class PipeSample {

    static void menu(InputStream in) {
        Scanner scanner = new Scanner(in);
        System.out.println("1 - to go 2 - not go 3 - exit");
        int code;

        while ((code = scanner.nextInt()) != 3) {
            switch (code) {
                case 1:
                    System.out.println("go");
                    break;
                case 2:
                    System.out.println("not go");
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PipedInputStream pin = new PipedInputStream();
        PipedOutputStream pout = new PipedOutputStream(pin);
        pout.write("1\n2\n3\n".getBytes());

        menu(pin);
    }
}
