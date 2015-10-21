package sorts;

/**
 * Created by Dennis on 10/20/2015.
 */
public class MyBubbleSort implements Sorting{

    public void sort(int[] arr) {

        for (int limit = arr.length - 1; limit >=0; limit--) {

            for (int i = 0; i < limit; i++) {

                if (arr[i] > arr[i + 1]) {

                    swap(arr, i, i + 1);

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
