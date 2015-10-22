package sorts;

/**
 * Created by Dennis on 10/23/2015.
 */
public class MyQuickSort implements Sorting {
    private int[] array;
    private int number;

    @Override
    public void sort(int[] array) {
        this.array = array;
        number = array.length;

        quickSort(0, number - 1);
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;

        // Get pivot element in the middle of the array
        int pivot = array[low + (high - low) / 2];

        // Divide by two arrays
        while (i <= j) {

            // If value in left side is smaller than the pivot - get next element;
            while (array[i] < pivot) {
                i++;
            }

            // If value in the right side is bigger than the pivot - get next element;
            while (array[j] > pivot) {
                j--;
            }

            // If we found bigger value in the left side from pivot and smaller
            // value in the right side, we should swap them
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(low, j);
        }

        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
