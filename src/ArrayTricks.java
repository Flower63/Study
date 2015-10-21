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
    public void maxElement(int[] array) {
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
    public void minElement(int[] array) {
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
    public void averageValue(int[] array) {
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
    public void pickedElements(int[] array) {
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
    public void zeroElements(int[] array) {
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
    public void moreThanZero(int[] array) {
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
    public void multiplyByNumber(int[] array) {
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
    public void addIndex(int[] array) {
        int[] outArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            outArray[i] = array[i] + i;
        }

        showArray(outArray);
    }

    /*
     * Set to zero each even element
     */
    public void zeroEvenElement(int[] array) {
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
    public void zeroElementOddIndex(int[] array) {
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
    public void firstPositive(int[] array) {
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
    public void lastNegative(int[] array) {
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
    public void elementInArrayEntrance(int[] array) {

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
    public void ascendingOrderCheck(int[] array) {
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
    public void decayOrderCheck(int[] array) {
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
    public void rightShift(int[] array) {
        int[] outArray = new int[array.length];
        int shift = 2;

        for (int i = 0; i < array.length; i++) {

            //outArray[(i + k) % array.length] = array[i];

            if (i + shift >= array.length) {
                outArray[i + shift - array.length] = array[i];
            } else {
                outArray[i + shift] = array[i];
            }
        }

        showArray(outArray);

//        for (int i = array.length - 1; i > 0; i--) {
//            array[i] = array[i - 1];
//        }
        // Consider
//        System.arraycopy(array, 0, outArray, shift, array.length - shift);
//        System.arraycopy(array, array.length - shift, outArray, 0, shift);
    }

    /*
     * Shows all repeated elements
     */
    public void repeatedElements(int[] array) {
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
    public ArrayList moreThanAverage(int[] array) {
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

        return elements;
    }

    /*
     * Shows unique elements in array
     */
    //TODO figure out return format
    public void uniqueValues(int[] array) {
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
     * Unique elements another realisation
     *
     * Not tested
     */
    public void printUnique(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean unique = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    unique = false;
                }
            }

            if (unique) {
                System.out.println(array[i]);
            }
        }
    }

    /*
     * Binary search
     *
     * Not tested
     *
     * Not finished
     */
    public static int binarySearch(int[] array, int value) {
        int lower = 0;
        int upper = array.length; // exclusive

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;

            if(array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                lower = mid + 1;
            } else {  //array[mid] > value
                upper = mid;
            }
        }

        return -1;  //
    }

    // Find
    public int findFirstValue(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /*
     * Collection - free realisation, truly evil
     */
    public static void printRepeats( int array[]) {

        boolean[] repeats = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {

                    if (!repeats[i]) {
                        System.out.println(array[i]);
                    }

                    repeats[i] = true;
                    repeats[j] = true;
                }
            }
        }
    }

    /*
     * Counts how often first element appears in array
     */
    public int asFirstElement(int[] array) {
        int count = 0;
        int firstElement = array[0];

        for (int i = 1; i < array.length; i++) {
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

        return array;
    }

    /*
     * Method main for testing purposes
     */
    public static void main(String[] args) {
        ArrayTricks instance = new ArrayTricks();

//        instance.sumOfElements();
//
//        instance.maxElement();
//
//        instance.minElement();
//
//        instance.averageValue();
//
//        instance.pickedElements();
//
//        instance.zeroElements();
//
//        instance.moreThanZero();
//
//        instance.multiplyByNumber();
//
//        instance.addIndex();
//
//        instance.zeroEvenElement();
//
//        instance.zeroElementOddIndex();
//
//        instance.firstPositive();
//
//        instance.lastNegative();
//
//        instance.elementInArrayEntrance();
//
//        instance.ascendingOrderCheck();
//
//        instance.decayOrderCheck();
//
//        instance.rightShift();
//
//        instance.repeatedElements();
//
//        instance.moreThanAverage();
//
//        instance.uniqueValues();
//
//        instance.asFirstElement();
//
//        instance.thirdSortedArray();
//
//        instance.swapPositiveElements();
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

    private void checkNotNull(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("array must be not null");
        }
    }
}
