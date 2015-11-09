package ua.epam.my_collections;

import junit.framework.TestCase;

import java.util.Iterator;

/**
 * @author Denis
 *
 * on 11/9/2015.
 */
public class MyLinkedListTest extends TestCase {
    MyLinkedList<Integer> list = new MyLinkedList<>();

    public void testAdd() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(20, list.size());
    }

    public void testRemove() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        list.remove(10);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(19, list.size());
    }

    public void testRemoveFirst() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        list.removeFirst();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(19, list.size());
    }

    public void testRemoveLast() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        list.removeLast();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        assertEquals(19, list.size());
    }

    public void testIterator() {
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            iterator.remove();
        }

        assertEquals(0, list.size());
    }

    public void testNull() {
        for (int i = 0; i < 20; i++) {
            list.add(null);
        }

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}