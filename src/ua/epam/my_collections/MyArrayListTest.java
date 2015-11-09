package ua.epam.my_collections;

import junit.framework.TestCase;

import java.util.Iterator;

/**
 * Created by Flower on 11/9/2015.
 */
public class MyArrayListTest extends TestCase {
    MyArrayList<Integer> list = new MyArrayList<>();

    public void testAdd() {
        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(19, list.size());
    }

    public void testSet() {
        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        list.set(10, 1000);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(1000, list.get(10) + 0);
    }

    public void testRemoveElement() {
        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        list.remove(new Integer(10));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(18, list.size());
    }

    public void testRemoveIndex() {
        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        list.remove(15);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(18, list.size());
    }

    public void testIterator() {

        for (int i = 1; i < 20; i++) {
            list.add(i);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void testAddNull() {
        try {
            list.add(null);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

}