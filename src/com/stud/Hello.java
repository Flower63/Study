package com.stud;

import java.util.Arrays;

/**
 * @author Dennis
 *
 * on 10/17/2015.
 */
public class Hello {
    public static void main(String[] args) {
    }

    /*
     * Arrays.copyOf() usage example
     */
    public static void arraysCopyOf() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] res = Arrays.copyOf(arr, 5);

        System.out.println(Arrays.toString(res));
    }

    /*
     * System.arraycopy() usage example
     *
     * pretty fast
     */
    public static void arrayCopySystem() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] copy = new int[arr.length];

        System.out.println(Arrays.toString(arr));

        System.arraycopy(arr, 0, copy, 5, arr.length - 5);

        System.out.println(Arrays.toString(copy));

        System.arraycopy(arr, arr.length - 5, copy, 0, 5);

        System.out.println(Arrays.toString(copy));
    }
}
