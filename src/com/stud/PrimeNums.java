package com.stud;

/**
 * Created by Dennis on 10/21/2015.
 */
public class PrimeNums {

    /*
     * Doesn't works!
     */
    public static void showPrimeNums() {

        num:
        for (int i = 2; i <= 100; i++) {

            int n = (int) Math.sqrt(i) + 1;

            while (--n != 0) {

                if (i % n == 0) {

                    continue num;
                }
            }

            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        showPrimeNums();
    }
}
