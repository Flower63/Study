/**
 * PyramidLoops
 *
 * @author  Dennis_Zvarich
 *
 * on 10/20/2015.
 */
public class PyramidLoops {

    /*
     * 00000
     * 1111
     * 222
     * 33
     * 4
     *
     * pattern
     */
    public void first(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[i]);
            }

            System.out.println();
        }
    }

    /*
     * 01234
     * 0123
     * 012
     * 01
     * 0
     *
     * pattern
     */
    public void second(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {
                System.out.print(arr[j]);
            }

            System.out.println();
        }
    }

    /*
     * 01234
     * 1234
     * 234
     * 34
     * 4
     *
     * pattern
     */
    public void third(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                System.out.print(arr[j]);
            }

            System.out.println();
        }
    }
}
