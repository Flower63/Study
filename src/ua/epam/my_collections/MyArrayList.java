package ua.epam.my_collections;

import java.util.Iterator;

/**
 * @author Denis
 *
 * on 11/9/2015.
 */
public class MyArrayList <T> implements Iterable<T> {
    private T[] values;
    private int size;

    public MyArrayList() {
        values = (T[]) new Object[10];
        size = 0;
    }

    public void add(T value) {
        if (size == values.length) {
            extendValues();
        }

        values[size++] = value;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return values[index];
    }

    public void set(int index, T value) {
        values[index] = value;
    }

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

    public int size() {
        return size;
    }

    private void extendValues() {
        T[] temp = (T[]) new Object[(values.length * 3) / 2 + 1];
        System.arraycopy(values, 0, temp, 0, values.length);
        values = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
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
    }
}
