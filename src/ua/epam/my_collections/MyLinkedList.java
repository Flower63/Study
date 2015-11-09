package ua.epam.my_collections;

import java.util.Iterator;

/**
 * Created by Flower on 11/9/2015.
 */
public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;

    private int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(T value) {
        if (size == 0) {
            first = new Node<>(value, null, null);
            last = first;
            size++;
        } else {
            last = new Node<>(value, null, last);
            size++;
        }
    }

    public T get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            return getFirst();
        } else if (index == size - 1) {
            return getLast();
        }

        int count = 0;

        Node result = first;

        while (result.hasNext()) {
            result = result.getNext();
            count++;
            if (count == index) {
                break;
            }
        }

        return (T) result.getValue();
    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> last;

        public Node(T value, Node<T> next, Node<T> last) {
            this.value = value;
            this.next = next;
            this.last = last;
        }

        public boolean hasNext() {
            return next != null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getLast() {
            return last;
        }
    }
}
