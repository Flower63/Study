package sorts;

import java.util.Arrays;

/**
 * Created by Dennis on 10/20/2015.
 */
public class SortingTest {

    public static void main(String[] args) {
        /*
         * Test array
         */
        int[] testArray = {2, -3, 5, 7, 1, 3, 4, 9, -6, 5, 8, 0, 6};

        testBubbleSort(testArray.clone());

        testSelectionSort(testArray.clone());

        testInsertionSort(testArray.clone());

        testMergeSort(testArray.clone());

        testQuickSort(testArray.clone());

    }

    public static void testBubbleSort(int[] testArray) {
        /*
         * Bubble sort
         */
        performTest(testArray, new MyBubbleSort());
    }

    public static void testSelectionSort(int[] testArray) {
        /*
         * Selection sort
         */
        performTest(testArray, new MySelectionSort());

    }

    public static void testInsertionSort(int[] testArray) {
        /*
         * Insertion sort
         */
        performTest(testArray, new MyInsertionSort());
    }

    public static void testMergeSort(int[] testArray) {
        /*
         * Merge sort
         */
        performTest(testArray, new MyMergeSort());
    }

    public static void testQuickSort(int[] testArray) {
        /*
         * Quick sort
         */
        performTest(testArray, new MyQuickSort());
    }

    private static void performTest(int[] testArray, Sorting instance) {

        System.out.println(instance.getClass().getSimpleName());

        System.out.println("Before: " + Arrays.toString(testArray));

        instance.sort(testArray);

        System.out.println("After: " + Arrays.toString(testArray));

        System.out.println();
    }
}
