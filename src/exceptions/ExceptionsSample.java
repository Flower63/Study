package exceptions;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Flower on 11/13/2015.
 */
public class ExceptionsSample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("c:/1.txt")) {



            int theByte;

            while ((theByte = fis.read()) != -1) {
                System.out.print((char) theByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
