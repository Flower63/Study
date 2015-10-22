import junit.framework.TestCase;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Flower on 10/21/2015.
 */
public class ArrayTricksTest extends TestCase {

    /* test arrays */
    int[] array = {2, -3, 5, 7, 1, 3, 4, 9, -6, 5, 8, 0, 6};
    int[] arraySwappedPositives = {6, -3, 8, 5, 9, 4, 3, 1, -6, 7, 5, 0, 2};
    int[] array0 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] arrayNegat = {0, -1, -2, -3, -4, -5, -6, -7, -8, -9};
    int[] array1 = {1, 3, 5, 7, 9, 11};
    int[] array2 = {2, 4, 6, 8, 10, 12};
    int[] array3 = {5, 5, 5, 1, 2, 3, 6, 6, 6};

    /* instance */
    ArrayTricks instance = new ArrayTricks();

    public void testSumOfElements() throws Exception {
        int sum = instance.sumOfElements(array0);

        assertEquals(45, sum);
    }

    public void testMaxElement() throws Exception {
        int max = instance.maxElement(array0);

        assertEquals(9, max);
    }

    public void testMinElement() throws Exception {
        int min = instance.minElement(array);

        assertEquals(-6, min);
    }

    public void testAverageValue() throws Exception {
        double average = instance.averageValue(array0);

        assertEquals(4.5, average);
    }

    public void testPickedElements() throws Exception {
        int appearance = instance.pickedElements(array, 5);

        assertEquals(2, appearance);
    }

    public void testZeroElements() throws Exception {
        int appearance = instance.zeroElements(array);

        assertEquals(1, appearance);
    }

    public void testMoreThanZero() throws Exception {
        int appearance = instance.moreThanZero(array0);

        assertEquals(9, appearance);
    }

    public void testMultiplyByNumber() throws Exception {
        int[] test = instance.multiplyByNumber(array, 1);

        assertNotNull(test);

        assertArrayEquals(array, test);

        int[] test2 = instance.multiplyByNumber(array0, 2);

        assertNotNull(test2);

        assertArrayEquals(new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18}, test2);
    }

    public void testAddIndex() throws Exception {
        int[] test = instance.addIndex(array0);

        assertNotNull(test);

        assertArrayEquals(new int[] {0, 2, 4, 6, 8, 10, 12, 14, 16, 18}, test);
    }

    public void testZeroEvenElement() throws Exception {
        int[] test = instance.zeroEvenElement(array0);

        assertNotNull(test);

        assertArrayEquals(new int[] {0, 1, 0, 3, 0, 5, 0, 7, 0, 9}, test);
    }

    public void testZeroElementOddIndex() throws Exception {
        int[] test = instance.zeroElementOddIndex(array0);

        assertNotNull(test);

        assertArrayEquals(new int[] {0, 0, 2, 0, 4, 0, 6, 0, 8, 0}, test);
    }

    public void testFirstPositive() throws Exception {
        int firstPositive = instance.firstPositive(array0);

        assertEquals(1, firstPositive);

        int noPositives = instance.firstPositive(arrayNegat);

        assertEquals(0, noPositives);
    }

    public void testLastNegative() throws Exception {
        int lastNegative = instance.lastNegative(array);

        assertEquals(-6, lastNegative);

        int noNegatives = instance.lastNegative(array0);

        assertEquals(0, noNegatives);

        int allNegatives = instance.lastNegative(arrayNegat);

        assertEquals(arrayNegat[arrayNegat.length - 1], allNegatives);
    }

    public void testIncreasingOrderCheck() throws Exception {
        boolean increasingOrder = instance.increasingOrderCheck(array0);

        assertTrue(increasingOrder);

        boolean notOrdered = instance.increasingOrderCheck(array);

        assertFalse(notOrdered);
    }

    public void testDecreasingOrderCheck() throws Exception {
        boolean decreasingOrder = instance.decreasingOrderCheck(arrayNegat);

        assertTrue(decreasingOrder);

        boolean notOrdered = instance.increasingOrderCheck(array);

        assertFalse(notOrdered);
    }

    public void testRightShift() throws Exception {
        int[] shiftedArray = instance.rightShift(array0, 2);

        assertNotNull(shiftedArray);

        assertArrayEquals(new int[] {8, 9, 0, 1, 2, 3, 4, 5, 6, 7}, shiftedArray);
    }

    public void testRepeatedElements() throws Exception {
        int[] repeatedNumbers = instance.repeatedElements(array);

        assertNotNull(repeatedNumbers);

        assertArrayEquals(new int[] {5}, repeatedNumbers);
    }

    public void testMoreThanAverage() throws Exception {
        int[] test = instance.moreThanAverage(array0);

        assertNotNull(test);

        assertArrayEquals(new int[] {5, 6, 7, 8, 9}, test);
    }

    public void testUniqueValues() throws Exception {
        int[] test = instance.uniqueValues(array3);

        assertNotNull(test);

        assertArrayEquals(new int[] {1, 2, 3}, test);
    }

    public void testAsFirstElement() throws Exception {
        int firstElement = instance.asFirstElement(array3);

        assertEquals(3, firstElement);
    }

    public void testThirdSortedArray() throws Exception {
        int[] test = instance.thirdSortedArray(array1, array2);

        assertNotNull(test);

        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, test);
    }

    public void testSwapPositiveElements() throws Exception {
        int[] test = instance.swapPositiveElements(array);

        assertNotNull(test);

        assertArrayEquals(arraySwappedPositives, array);
    }
}