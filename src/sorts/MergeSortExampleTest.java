package sorts;

import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
 * Created by Dennis on 10/21/2015.
 */
public class MergeSortExampleTest extends TestCase {
   /*
    * Test arrays
    */
    int[] testArray = {2, -3, 5, 7, 1, 3, 4, 9, -6, 5, 8, 0, 6};
    int[] sortedArray = {-6, -3, 0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};

    public void testSort() throws Exception {

        int[] resultArray = MergeSortExample.sort(testArray);

        assertArrayEquals(sortedArray, resultArray);
    }
}