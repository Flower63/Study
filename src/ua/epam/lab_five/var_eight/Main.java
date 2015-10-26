package ua.epam.lab_five.var_eight;

import ua.epam.lab_five.Tester;

/**
 * This class invokes required tasks in variant 8
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
        Student cash = new Student("John Cash", 5, 123);

        Tester.invokeAnnotatedMethods(cash);

        Graduand morrison = new Graduand("Jim Morrison", 4, 124, "Total destination of the doors");

        Tester.invokeAnnotatedMethods(morrison);

        /*
         * Task 2
         */
        Tester.showSuperclass(morrison);

        /*
         * Task 1
         */
        Tester.showMethods(morrison);

        Tester.showMethods(cash);
    }


}
