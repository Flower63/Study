package sorts;

/**
 * Created by Dennis on 10/21/2015.
 */
public class MyInsertionSort implements Sorting {

    @Override
    public void sort(int[] testArray) {

        for (int i = 1; i < testArray.length; i++) {

            int tempVal = testArray[i];

            int index = i - 1;

            while (index >= 0 && testArray[index] > tempVal) {

                testArray[index + 1] = testArray[index];

                index--;
            }

            testArray[index + 1] = tempVal;
        }
    }
}
