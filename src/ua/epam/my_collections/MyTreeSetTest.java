package ua.epam.my_collections;

import org.junit.Test;

import java.util.Iterator;

/**
 * @author Dennis
 *
 * on 12/3/2015.
 */
public class MyTreeSetTest {

    @Test
    public void testAdd() {
        MyTreeSet<Integer> set = new MyTreeSet<>();

        int[] nums = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Iterator<Integer> iter = set.getRecursiveIterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Iterator<Integer> iter2 = set.getNonRecursiveIterator();

        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }

    @Test
    public void testRemove() {
        MyTreeSet<Integer> set = new MyTreeSet<>();

        int[] nums = { 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Iterator<Integer> iter = set.getRecursiveIterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        set.remove(8);

        Iterator<Integer> iter2 = set.getNonRecursiveIterator();

        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }

}