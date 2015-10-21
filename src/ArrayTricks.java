import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Each method of this class corresponds to separate task in tasks list.
 * They appears in very same order
 *
 * @author  Dennis_Zvarich
 *
 * on 10/20/2015.
 */
public class ArrayTricks {

    /* test arrays */
    int[] array = {2, -3, 5, 7, 1, 3, 4, 9, -6, 5, 8, 0, 6};
    int[] array1 = {1, 3, 5, 7, 9, 11};
    int[] array2 = {2, 4, 6, 8, 10, 12};

    /*
     * Counts sum of array
     */
    public void sumOfElements() {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println(sum);
    }

    /*
     * Finds max element in array
     */
    public void maxElement() {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for(int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        System.out.println(max + " " + maxIndex);
    }

    /*
     * Finds min element in array
     */
    public void minElement() {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for(int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }

        System.out.println(min + " " + minIndex);
    }

    /*
     * Finds average value of all elements in array
     */
    public void averageValue() {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = (double) sum / array.length;

        System.out.println(average);
    }

    /*
     * Counts, how often picked element appears in array
     */
    public void pickedElements() {
        int pickedElement = 5;      //assume so
        int appearance = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == pickedElement) {
                appearance++;
            }
        }

        System.out.println(appearance);
    }

    /*
     * Counts all zero elements in array;
     */
    public void zeroElements() {
        int appearance = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                appearance++;
            }
        }

        System.out.println(appearance);
    }

    /*
     * Counts all positive elements in array
     */
    public void moreThanZero() {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }

        System.out.println(count);
    }

    /*
     * Multiplies all elements to specified value
     */
    public void multiplyByNumber() {
        int number = 5;
        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            outArray[i] = array[i] * number;
        }

        showArray(outArray);
    }

    /*
     * To each element in array adds its index
     */
    public void addIndex() {
        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            outArray[i] = array[i] + i;
        }

        showArray(outArray);
    }

    /*
     * Set to zero each even element
     */
    public void zeroEvenElement() {
        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                continue;
            }

            outArray[i] = array[i];
        }

        showArray(outArray);
    }

    /*
     * Set to zero each element with odd index
     */
    public void zeroElementOddIndex() {
        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                continue;
            }

            outArray[i] = array[i];
        }

        showArray(outArray);
    }

    /*
     * Finds first value in array
     */
    public void firstPositive() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                System.out.println(array[i]);
                return;
            }
        }

        System.out.println("No positive values");
    }

    /*
     * Finds last negative value in array
     */
    public void lastNegative() {
        int indexOfNegative = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                indexOfNegative = i;
            }
        }

        if (indexOfNegative < 0) {
            System.out.println("No negative values");
        } else {
            System.out.println(array[indexOfNegative]);
        }
    }

    /*
     * Counts how often specified elements appears in array (outputs indexes)
     */
    public void elementInArrayEntrance() {

        int element = 5;
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                indexes.add(i);
            }
        }

        System.out.println(indexes);
    }

    /*
     * Checks, if array sorted in ascending order
     */
    public void ascendingOrderCheck() {
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                System.out.println("Elements aren't ordered by ascending");
                return;
            }
        }

        System.out.println("Elements ordered by ascending");
    }

    /*
     * Checks, if array sorted in decay order
     */
    public void decayOrderCheck() {
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                System.out.println("Elements aren't ordered by decay");
                return;
            }
        }

        System.out.println("Elements ordered by decay");
    }

    /*
     * Shifts all elements to right for specified number of posissions
     */
    public void rightShift() {
        int[] outArray = new int[array.length];
        int shift = 2;

        for (int i = 0; i < array.length; i++) {
            if (i + shift >= array.length) {
                outArray[i + shift - array.length] = array[i];
            } else {
                outArray[i + shift] = array[i];
            }
        }

        showArray(outArray);
    }

    /*
     * Shows all repeated elements
     */
    public void repeatedElements() {
        HashMap<Integer, Integer> statistic = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (!statistic.containsKey(array[i])) {
                statistic.put(array[i], 0);
            } else {
                statistic.put(array[i], statistic.get(array[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : statistic.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.print(entry.getKey() + " ");
            }
        }

        System.out.println();
    }

    /*
     * Shows all elements, that greater than average value
     */
    public void moreThanAverage() {
        int sum = 0;
        ArrayList<Integer> elements = new ArrayList<Integer>();

        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = (double) sum / array.length;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > average) {
                elements.add(array[i]);
            }
        }

        System.out.println(elements);
    }

    /*
     * Shows unique elements in array
     */
    public void uniqueValues() {
        HashMap<Integer, Integer> statistic = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (!statistic.containsKey(array[i])) {
                statistic.put(array[i], 0);
            } else {
                statistic.put(array[i], statistic.get(array[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : statistic.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.print(entry.getKey() + " ");
            }
        }

        System.out.println();
    }

    /*
     * Counts how often first element appears in array
     */
    public void asFirstElement() {
        int count = 0;
        int firstElement = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] == firstElement) {
                count++;
            }
        }

        System.out.println(count);
    }

    /*
     * Creates one big sorted array from to sorted smaller ones
     */
    public void thirdSortedArray() {
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

        showArray(outArray);
    }

    /*
     * Swaps positive elements heads to tails
     */
    public void swapPositiveElements() {
        int head = 0;
        int tail = array.length - 1;

        while (head < tail) {
            if (array[head] > 0 && array[tail] > 0) {       // swap
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

        showArray(array);
    }

    /*
     * Method main for testing purposes
     */
    public static void main(String[] args) {
        ArrayTricks instance = new ArrayTricks();

        instance.sumOfElements();

        instance.maxElement();

        instance.minElement();

        instance.averageValue();

        instance.pickedElements();

        instance.zeroElements();

        instance.moreThanZero();

        instance.multiplyByNumber();

        instance.addIndex();

        instance.zeroEvenElement();

        instance.zeroElementOddIndex();

        instance.firstPositive();

        instance.lastNegative();

        instance.elementInArrayEntrance();

        instance.ascendingOrderCheck();

        instance.decayOrderCheck();

        instance.rightShift();

        instance.repeatedElements();

        instance.moreThanAverage();

        instance.uniqueValues();

        instance.asFirstElement();

        instance.thirdSortedArray();

        instance.swapPositiveElements();
    }

    /*
     * Method to print array
     */
    private void showArray(int[] outArray) {
        for (int x : outArray) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
