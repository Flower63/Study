package search;

/**
 * Created by Dennis on 10/22/2015.
 */
public class MyBinarySearch {

    public static int search(int[] array, int value) {

        int from = 0;
        int to = array.length;
        int index = -1;

        while (from < to) {
            int mid = from + (to - from) / 2;

            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                from = mid + 1;
            } else {            //array[mid] > value
                to = mid;
            }
        }

        return index;
    }
}
