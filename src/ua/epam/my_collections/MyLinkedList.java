package ua.epam.my_collections;

import java.util.Iterator;

/**
 * Linked list implementation. Just for study purposes
 *
 * @author Denis
 *
 * on 11/9/2015.
 */
public class MyLinkedList<T> implements Iterable<T> {

    /**
     * Represents first element
     */
    private Node first;

    /**
     * Represents last element
     */
    private Node last;

    /**
     * Total number of elements
     */
    private int size;

    /**
     * Constructor
     */
    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Adding element to collection
     *
     * null acceptable
     *
     * @param value - Input value
     */
    public void add(T value) {
        if (size == 0) {
            first = new Node(value, null, null);
            last = first;
            size++;
        } else {
            Node node = new Node(value, null, last);
            last.setNext(node);
            last = node;
            size++;
        }
    }

    /**
     * Returns element by specified index
     *
     * @param index - Index of element
     * @return - Relative value
     */
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

        return result.getValue();
    }

    /**
     * Returns first element in collection
     *
     * @return first element in collection
     */
    public T getFirst() {
        if (first != null) {
            return first.value;
        }

        throw new IndexOutOfBoundsException("No elements");
    }

    /**
     * Returns last element in collection
     *
     * @return last element in collection
     */
    public T getLast() {
        if (last != null) {
            return last.value;
        }

        throw new IndexOutOfBoundsException("No elements");
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
     * Removing element by specified index
     *
     * @param index of element to remove
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index == 0) {
            removeFirst();
            return;
        } else if (index == (size - 1)) {
            removeLast();
            return;
        }

        int count = 0;
        Node temp = first;

        while (count != index) {
            temp = temp.getNext();
            count++;
        }

        Node prev = temp.getLast();
        Node next = temp.getNext();

        prev.setNext(next);
        next.setLast(prev);

        size--;
    }

    /**
     * Removing first element in collection
     */
    public void removeFirst() {
        if (size > 0) {
            first = first.getNext();
            size--;
        }
    }

    /**
     * Removing last element in collection
     */
    public void removeLast() {
        if (size > 0) {
            last = last.getLast();
            size--;
        }
    }

    /**
     * Creates and returns iterator for this collection
     *
     * @return new Iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return get(cursor++);
            }

            @Override
            public void remove() {
                MyLinkedList.this.remove(cursor);
            }
        };
    }

    /**
     * Type to hold values and links
     * (to previous and next element)
     */
    private class Node {
        T value;
        Node next;
        Node last;

        public Node(T value, Node next, Node last) {
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

        public Node getNext() {
            return next;
        }

        public Node getLast() {
            return last;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setLast(Node last) {
            this.last = last;
        }
    }
}
