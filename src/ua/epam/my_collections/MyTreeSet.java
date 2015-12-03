package ua.epam.my_collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;

/**
 * My implementation of TreeSet
 *
 * @author Dennis
 *
 * on 11/27/2015.
 */
public class MyTreeSet<T extends Comparable<T>> {

    /**
     * Size of set
     */
    private int size;

    /**
     * Root node
     */
    private Node<T> root;

    /**
     * Adding element
     *
     * @param t element to hold
     * @return result of operation
     */
    public boolean add(T t) {

        if (root == null) {
            root = new Node<>(t, null, null, null);
        } else {
            addNode(root, t);
        }

        size++;
        return true;
    }

    /**
     * Adding value to specified node
     *
     * @param node node to find proper place
     * @param t element to hold
     */
    private void addNode(Node node, T t) {
        if (node.item.equals(t)) {
            return;
        } else if (node.item.compareTo(t) > 0) {
            if (node.leftNode != null) {
                addNode(node.leftNode, t);
            } else {
                node.leftNode = new Node(t, null, null, node);
            }
        } else {
            if (node.rightNode != null) {
                addNode(node.rightNode, t);
            } else {
                node.rightNode = new Node(t, null, null, node);
            }
        }
    }

    /**
     * Getting node, that contains specified value
     *
     * @param node Node to searching from
     * @param t element to find
     * @return Corresponding node
     * @return Null if node not found
     */
    private Node getNode(Node node, T t) {

        if (node.item.equals(t)) {
            return node;
        } else if (node.item.compareTo(t) > 0) {
            if (node.leftNode != null) {
                return getNode(node.leftNode, t);
            } else {
                return null;
            }
        } else {
            if (node.rightNode != null) {
                return getNode(node.rightNode, t);
            } else {
                return null;
            }
        }
    }

    /**
     * Removing node by specified element
     *
     * @param t element to find
     */
    public void remove(T t) {

        Node node = getNode(root, t);

        if (node == null) {
            return;
        }

        if (node == root && size == 1) {
            root = null;
            size--;
            return;
        }

        if (node.leftNode == null && node.rightNode == null) {
            removeNode(node, null);
        } else if (node.rightNode != null && node.leftNode == null) {
            removeNode(node, node.rightNode);
        } else if (node.rightNode == null) {
            removeNode(node, node.leftNode);
        } else {
            Node successor = node.rightNode;

            while (successor.leftNode != null) {
                successor = successor.leftNode;
            }

            node.item = successor.item;
            removeNode(successor, successor.rightNode);
        }
    }

    /**
     * Removing node, depending of its position in parent node
     *
     * @param node Node to process
     * @param childNode Replacement
     */
    private void removeNode(Node node, Node childNode) {
        Node parent = node.parent;

        if (parent.leftNode == node) {
            parent.leftNode = childNode;
        } else {
            parent.rightNode = childNode;
        }

        size--;
    }

    /**
     * Checking of element existence in set
     *
     * @param t Element to find
     * @return Result of check. True if found, false otherwise
     */
    public boolean contains(T t) {
        return getNode(root, t) != null;
    }

    /**
     * Size of set
     *
     * @return Size
     */
    public int size() {
        return size;
    }

    /**
     * Set iterator
     *
     * @return iterator
     */
    public Iterator<T> iterator() {
        if (size > 5000) {
            return getNonRecursiveIterator();
        }

        return getRecursiveIterator();
    }

    /**
     * Getting iterator of non-recursive type
     *
     * @return iterator
     */
    public Iterator<T> getNonRecursiveIterator() {
        return new NonRecursiveIterator();
    }

    /**
     * Getting iterator of recursive type
     *
     * @return iterator
     */
    public Iterator<T> getRecursiveIterator() {
        return new RecursiveIterator();
    }

    /**
     * Recursive implementation of Iterator
     */
    private class RecursiveIterator implements Iterator<T> {
        Queue<T> queue = new LinkedList<>();

        RecursiveIterator() {
            fillQueue(root);
        }

        private void fillQueue(Node node) {

            if (node == null) {
                return;
            }

            fillQueue(node.leftNode);
            queue.offer((T) node.item);
            fillQueue(node.rightNode);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            return queue.poll();
        }
    }

    /**
     * Non-recursive implementation of Iterator
     */
    private class NonRecursiveIterator implements Iterator<T> {
        Node next;

        NonRecursiveIterator() {
            if (root != null) {
                next = firstNode(root);
            }
        }

        private Node firstNode(Node root) {
            if (root.leftNode == null) {
                return root;
            } else {
                return firstNode(root.leftNode);
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            Node current = next;
            if (next.rightNode != null) {
                next = next.rightNode;

                while (next.leftNode != null) {
                    next = next.leftNode;
                }

                return (T) current.item;
            } else {
                while (true) {
                    if (next.parent == null) {
                        next = null;
                        return (T) current.item;
                    }

                    if (next.parent.leftNode == next) {
                        next = next.parent;
                        return (T) current.item;
                    }

                    next = next.parent;
                }
            }
        }
    }

    /**
     * Node class
     *
     * @param <T> - type of element to hold
     */
    private static class Node<T extends Comparable<T>> {
        private T item;
        private Node<T> leftNode;
        private Node<T> rightNode;
        private Node<T> parent;

        public Node(T item, Node<T> leftNode, Node<T> rightNode, Node<T> parent) {
            this.item = item;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.parent = parent;
        }
    }
}
