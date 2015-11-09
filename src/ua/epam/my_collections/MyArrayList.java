package ua.epam.my_collections;

import java.util.Iterator;

/**
 * Array list implementation. Just for study purposes
 *
 * @author Denis
 *
 * on 11/9/2015.
 */
@SuppressWarnings("unchecked")
public class MyArrayList <T> implements Iterable<T> {

    /**
     * Array to hold values
     */
    private T[] values;

    /**
     * Number of elements, that holds in array
     */
    private int size;

    /**
     * Constructor
     */
    public MyArrayList() {
        values = (T[]) new Object[10];
        size = 0;
    }

    /**
     * Adds element to collection
     *
     * null elements are not allowed
     *
     * @param value Input element
     */
    public void add(T value) {
        if (size == values.length) {
            extendValues();
        }

        /*
         * null values are not allowed!
         */
        if (value == null) {
            throw new IllegalArgumentException();
        }

        values[size++] = value;
    }

    /**
     * Returns element in collection by specified index
     *
     * @param index - Index of specified element
     * @return - Relative value
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return values[index];
    }

    /**
     * Sets specified element to specified position
     *
     * @param index Position to set element
     * @param value Given value
     */
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        values[index] = value;
    }

    /**
     * Removing element by specified value
     *
     * @param value Value to remove
     */
    public void remove(T value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) {
                System.arraycopy(values, (i + 1), values, i, values.length - i - 1);
                values[values.length - 1] = null;
                size--;
                return;
            }
        }
    }

    /**
     * Removing element by specified index
     *
     * @param index of element to remove
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(values, (index + 1), values, index, values.length - index - 1);
        values[values.length - 1] = null;
        size--;
    }

    /**
     * Returns number of elements in collection
     *
     * @return number of elements
     */
    public int size() {
        return size;
    }

    /**
     * Extends array in case of overflow
     */
    private void extendValues() {
        T[] temp = (T[]) new Object[(values.length * 3) / 2 + 1];
        System.arraycopy(values, 0, temp, 0, values.length);
        values = temp;
    }

    /**
     * Creates and returns iterator for this collection
     *
     * @return new Iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return values[cursor++];
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(get(cursor));
            }
        };
    }
}
