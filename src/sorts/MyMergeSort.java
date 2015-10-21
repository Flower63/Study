package sorts;

/**
 * Created by Dennis on 10/21/2015.
 */
public class MyMergeSort implements Sorting {

    private int[] array;
    private int[] helper;

    @Override
    public void sort(int[] testArray) {

        int number = testArray.length;
        array = testArray;
        helper = new int[array.length];

        mergeSort(0, number - 1);
    }

    private void mergeSort(int low, int high) {

        /* If high smaller than low, array is sorted */
        if (low < high) {

            // Get index of the element, which is in the middle
            int mid = low + (high - low) / 2;

            // Sorts left side of the array
            mergeSort(low, mid);

            // Sorts right side of the array
            mergeSort(mid + 1, high);

            // combine both
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {

        // Copy both parts into helper array
        for (int i = 0; i <= high; i++) {
            helper[i] = array[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        // Copy smallest parts from the left or the right side to the original array
        while (i <= mid && j <= high) {
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;
        }

        //Copy rest of the left side into the target array
        while (i <= mid) {
            array[k] = helper[i];
            k++;
            i++;
        }
    }
}
