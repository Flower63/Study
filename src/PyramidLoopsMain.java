/**
 * SortingTest class for PyramidLoops
 * to run and perform some tests
 *
 * @author Dennis_Zvarich
 *
 * on 10/20/2015.
 */
public class PyramidLoopsMain {
    public static void main(String[] args) {

        int[] testArray = {0, 1, 2, 3, 4};
        PyramidLoops instance = new PyramidLoops();

        instance.first(testArray);

        instance.second(testArray);

        instance.third(testArray);
    }
}
