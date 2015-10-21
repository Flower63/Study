package sorts;

/**
 * Created by Dennis on 10/20/2015.
 */
public class MySelectionSort implements Sorting {

    public void sort(int[] arr) {

        for (int barier = 0; barier < arr.length - 1; barier++) {

            for (int index = barier + 1; index < arr.length; index++) {

                if (arr[index] < arr[barier]) {

                    swap(arr, index, barier);

                }
            }
        }
    }

    private void swap(int[] arr, int first, int second) {

        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }
}
