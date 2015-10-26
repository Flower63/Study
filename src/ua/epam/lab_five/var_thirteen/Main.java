package ua.epam.lab_five.var_thirteen;

import ua.epam.lab_five.Tester;

/**
 * This class invokes required tasks in variant 13
 *
 * @author  Dennis_Zvarich
 *
 * on 10/25/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        /*
         * General task
         */
        MobilePhone sony = new MobilePhone("SonyEricsson K800", 200, 4, 512, true);

        Tester.invokeAnnotatedMethods(sony);

        SmartPhone samsung = new SmartPhone("Samsung GALAXY S3", 200, 5.5, 16000, true, 1.5, 4, 1024);

        Tester.invokeAnnotatedMethods(samsung);

        /*
         * Task 2
         */
        Tester.showSuperclass(samsung);

        /*
         * Task 1
         */
        Tester.showMethods(sony);

        Tester.showMethods(samsung);
    }
}
