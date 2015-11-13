package ua.epam.my_collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Linked list implementation. Just for study purposes
 *
 * @author Denis
 *
 * on 11/9/2015.
 */
//@SuppressWarnings("all")
public class MyLinkedList<T> implements List<T> {

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
    public boolean add(T value) {
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

        return true;
    }

    /**
     * Returns element by specified index
     *
     * @param index - Index of element
     * @return - Relative value
     */
    public T get(int index) {
        return getNodeByIndex(index).getValue();
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
    public T remove(int index) {
        Node temp = getNodeByIndex(index);

        removeElement(temp);

        return temp.getValue();
    }

    private void removeElement(Node element) {
        Node prev = element.getLast();
        Node next = element.getNext();

        if (prev != null) {
            prev.setNext(next);
        }

        if (next != null) {
            next.setLast(prev);
        }

        size--;
    }

    /**
     * Removing first element in collection
     */
    public T removeFirst() {
        Node temp = first;

        if (size > 0) {
            first = first.getNext();

            if (size == 1) {
                last = null;
            }

            size--;
        }

        return temp.getValue();
    }

    /**
     * Removing last element in collection
     */
    public T removeLast() {
        Node temp = last;

        if (size > 0) {
            last = last.getLast();

            if (size == 1) {
                first = null;
            }

            size--;
        }

        return temp.getValue();
    }

    /**
     * Creates and returns iterator for this collection
     *
     * @return new Iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node element = first;

            @Override
            public boolean hasNext() {
                return element != null;
            }

            @Override
            public T next() {
                T value = null;

                if (element != null) {
                    value = element.getValue();
                    element = element.getNext();
                }

                return value;
            }

            @Override
            public void remove() {
                removeElement(element);
            }
        };
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {

        Object[] result = new Object[size];
        Node temp = first;
        int cursor = 0;

        while (temp != null) {
            result[cursor++] = temp.getValue();
            temp = temp.getNext();
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(T1[] a) {

        if (a.length < size) {
            a = (T1[]) new Object[size];
        }

        Object[] result = a;

        int cursor = 0;

        for(Node n = first; n != null; n = n.getNext()) {
            result[cursor++] = n.getValue();
        }

        while (a.length > size) {
            a[cursor++] = null;
        }

        return a;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node x = first; x != null; x = x.getNext()) {
                if (x.getValue() == null) {
                    removeElement(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.getNext()) {
                if (o.equals(x.getValue())) {
                    removeElement(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        Iterator iterator = c.iterator();
        while (iterator().hasNext()) {
            if (!contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    //TODO
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    //TODO
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    //TODO
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    //TODO
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public T set(int index, T element) {
        Node node = getNodeByIndex(index);
        T value = node.getValue();
        node.setValue(element);

        return value;
    }

    @Override
    public void add(int index, T element) {
        if (size == 0) {
            add(element);
            return;
        }

        Node temp = getNodeByIndex(index);
        Node newNode = new Node(element, temp, temp.getLast());

        temp.setLast(newNode);

        if (newNode.getLast() != null) {
            newNode.getLast().setNext(newNode);
        }

        size++;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;

        if (o == null) {
            for (Node x = first; x != null; x = x.getNext()) {
                if (x.getValue() == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node x = first; x != null; x = x.getNext()) {
                if (o.equals(x.getValue())) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    //TODO
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    //TODO
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    //TODO
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    //TODO
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private Node getNodeByIndex(int index) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        } else if (index == (size - 1)) {
            return last;
        }

        Node res = first;
        int count = 0;

        while (count != index) {
            res = res.getNext();
            count++;
        }

        return res;
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

        public void setValue(T value) {
            this.value = value;
        }
    }
}
