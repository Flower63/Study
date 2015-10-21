/**
 * Created by Flower on 10/21/2015.
 */
public class MergeSortExample {

    public static int[] sort(int[] array) {

        int[] temp = new int[array.length];

        int from = 0;
        int mid = array.length / 2;
        int to = array.length;

        mergeSorter(array, from, mid, temp);
        mergeSorter(array, mid, to, temp);

        return merger( array, from, mid, to, temp);
    }

    private static int[] merger(int[] array, int from, int mid, int to, int[] temp) {
        int first = 0;
        int second = mid;
        int result = 0;

        while ( first < mid && second < to) {
            if (array[first] < array[second]) {
                temp[result++] = array[first++];
            } else {
                temp[result++] = array[second++];
            }
        }

        while (first < mid) {
            temp[result++] = array[first++];
        }

        while (second < to) {
            temp[result++] = array[second++];
        }

        return temp;
    }

    private static void mergeSorter(int[] array, int from, int to, int[] temp) {
        if (to - from <= 1) {
            return;
        }

        int mid = from + (to - from) / 2;

        mergeSorter(array, from, mid, temp);

        mergeSorter(array, mid, to, temp);


    }
}
