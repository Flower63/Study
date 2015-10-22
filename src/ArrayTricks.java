import java.util.Arrays;

/**
 * Each method of this class corresponds to separate task in tasks list.
 * They appears in very same order
 *
 * @author  Dennis_Zvarich
 *
 * on 10/20/2015.
 */
public class ArrayTricks {

    /*
     * Counts sum of array
     */
    public int sumOfElements(int[] array) {

        checkNotNull(array);

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return  sum;
    }

    /*
     * Finds max element in array
     */
    public int maxElement(int[] array) {

        checkNotNull(array);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    /*
     * Finds min element in array
     */
    public int minElement(int[] array) {

        checkNotNull(array);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    /*
     * Finds average value of all elements in array
     */
    public double averageValue(int[] array) {

        checkNotNull(array);

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = (double) sum / array.length;

        return average;
    }

    /*
     * Counts, how often picked element appears in array
     */
    public int pickedElements(int[] array, int value) {

        checkNotNull(array);

        int pickedElement = value;
        int appearance = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == pickedElement) {
                appearance++;
            }
        }

        return appearance;
    }

    /*
     * Counts all zero elements in array;
     */
    public int zeroElements(int[] array) {

        checkNotNull(array);

        int appearance = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                appearance++;
            }
        }

        return appearance;
    }

    /*
     * Counts all positive elements in array
     */
    public int moreThanZero(int[] array) {

        checkNotNull(array);

        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }

        return count;
    }

    /*
     * Multiplies all elements to specified value
     */
    public int[] multiplyByNumber(int[] array, int number) {

        checkNotNull(array);

        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            outArray[i] = array[i] * number;
        }

        return outArray;
    }

    /*
     * To each element in array adds its index
     */
    public int[] addIndex(int[] array) {

        checkNotNull(array);

        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            outArray[i] = array[i] + i;
        }

        return outArray;
    }

    /*
     * Set to zero each even element
     */
    public int[] zeroEvenElement(int[] array) {

        checkNotNull(array);

        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                continue;
            }

            outArray[i] = array[i];
        }

        return outArray;
    }

    /*
     * Set to zero each element with odd index
     */
    public int[] zeroElementOddIndex(int[] array) {

        checkNotNull(array);

        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                continue;
            }

            outArray[i] = array[i];
        }

        return outArray;
    }

    /*
     * Finds first value in array
     */
    public int firstPositive(int[] array) {

        checkNotNull(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                return array[i];
            }
        }

        // If no positive values found
        return 0;
    }

    /*
     * Finds last negative value in array
     */
    public int lastNegative(int[] array) {

        checkNotNull(array);

        int indexOfNegative = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                indexOfNegative = i;
            }
        }

        if (indexOfNegative >= 0) {
            return array[indexOfNegative];
        }

        // In no negative values found
        return 0;
    }

    /*
     * Checks, if array sorted in increasing order
     */
    public boolean increasingOrderCheck(int[] array) {

        checkNotNull(array);
        checkNotEmpty(array);

        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /*
     * Checks, if array sorted in decreasing order
     */
    public boolean decreasingOrderCheck(int[] array) {

        checkNotNull(array);
        checkNotEmpty(array);

        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /*
     * Shifts all elements to right for specified number of posissions
     */
    public int[] rightShift(int[] array, int shift) {

        checkNotNull(array);
        checkNotEmpty(array);

        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            outArray[(i + shift) % array.length] = array[i];
        }

        return outArray;
    }

    public int[] insert(int[] array, int element, int position) {

        if (position < 0 || position > array.length) {
            throw new IllegalArgumentException("invalid position index");
        }
        checkNotNull(array);
        checkNotEmpty(array);

        int[] outArray = new int[array.length + 1];

        for (int i = 0; i < position; i++) {
            outArray[i] = array[i];
        }

        outArray[position] = element;

        for (int i = position; i < array.length; i++) {
            outArray[i + 1] = array[i];
        }

        return outArray;
    }

    /*
     * Shows all repeated elements
     */
    public int[] repeatedElements(int[] array) {

        checkNotNull(array);
        checkNotEmpty(array);

        boolean[] repeats = new boolean[array.length];
        int[] repeatedNumbers = new int[array.length];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    if (!repeats[i]) {
                        repeatedNumbers[index++] = array[i];
                    }

                    repeats[i] = true;
                    repeats[j] = true;
                }
            }
        }

        return Arrays.copyOf(repeatedNumbers, index);
    }

    /*
     * Shows all elements, that greater than average value
     */
    public int[] moreThanAverage(int[] array) {

        checkNotNull(array);
        checkNotEmpty(array);

        int index = 0;
        int[] outArray = new int[array.length];
        double average = averageValue(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                outArray[index++] = array[i];
            }
        }

        return Arrays.copyOf(outArray, index);
    }

    /*
     * Returns unique elements in array
     */
    public int[] uniqueValues(int[] array) {

        checkNotNull(array);
        checkNotEmpty(array);

        int index = 0;
        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            boolean unique = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    unique = false;
                }
            }

            if (unique) {
                outArray[index++] = array[i];
            }
        }

        return Arrays.copyOf(outArray, index);
    }

    /*
     * Counts how often first element appears in array
     */
    public int asFirstElement(int[] array) {

        checkNotNull(array);
        checkNotEmpty(array);

        int count = 0;
        int firstElement = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                count++;
            }
        }

        return count;
    }

    /*
     * Creates one big sorted array from to sorted smaller ones
     */
    public int[] thirdSortedArray(int[] array1, int[] array2) {

        checkNotNull(array1);
        checkNotNull(array2);

        checkNotEmpty(array1);
        checkNotEmpty(array2);

        int first = 0;
        int second = 0;
        int[] outArray = new int[array1.length + array2.length];

        for (int i = 0; i < outArray.length; i++) {
            if (first == array1.length) {
                outArray[i] = array2[second++];
            } else if (second == array2.length) {
                outArray[i] = array1[first++];
            } else if (array1[first] > array2[second]) {
                outArray[i] = array2[second++];
            } else if (array1[first] < array2[second]) {
                outArray[i] = array1[first++];
            }
        }

        return outArray;
    }

    /*
     * Swaps positive elements heads to tails
     */
    public int[] swapPositiveElements(int[] array) {

        checkNotNull(array);
        checkNotEmpty(array);

        int head = 0;
        int tail = array.length - 1;

        while (head < tail) {
            if (array[head] > 0 && array[tail] > 0) {
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;

                head++;
                tail--;
            } else if (array[head] < 0 && array[tail] > 0) {
                head++;
            } else if (array[head] > 0 && array[tail] < 0) {
                tail--;
            } else {
                head++;
                tail--;
            }
        }

        return array;
    }

    private void checkNotNull(int[] array) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException("array must be not null");
        }
    }

    private void checkNotEmpty(int[] array) throws IllegalArgumentException {
        if (array.length == 0) {
            throw new IllegalArgumentException("array must not be empty");
        }
    }
}
