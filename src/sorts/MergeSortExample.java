package sorts;

import java.util.Arrays;

/**
 * Created by Flower on 10/21/2015.
 */
public class MergeSortExample {

    private static int[] temp;
    private static int[] arr;

    public static int[] sort(int[] array) {

        arr = array;
        temp = new int[array.length];

        int from = 0;
        int mid = array.length / 2;
        int to = array.length;

        mergeSorter(from, mid);
        mergeSorter(mid, to);

        merger(from, mid, to);

        return arr;
    }

    private static void merger(int from, int mid, int to) {
        int first = from;
        int second = mid;
        int result = 0;

        while ( first < mid && second < to) {
            if (arr[first] < arr[second]) {
                temp[result++] = arr[first++];
            } else {
                temp[result++] = arr[second++];
            }
        }

        while (first < mid) {
            temp[result++] = arr[first++];
        }

        while (second < to) {
            temp[result++] = arr[second++];
        }

        System.arraycopy(temp, 0, arr, from, to-from);
    }

    private static void mergeSorter(int from, int to) {
        if (to - from <= 1) {
            return;
        }

        int mid = from + (to - from) / 2;

        mergeSorter(from, mid);

        mergeSorter(mid, to);

        merger(from, mid, to);
    }
}
