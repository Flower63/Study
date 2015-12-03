package ua.epam.my_collections;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Flower
 *
 * on 11/27/2015.
 */
public class MyTreeSet<T extends Comparable<T>> {

    private int size;
    private Node<T> root;

    public boolean add(T t) {

        if (root == null) {
            root = new Node<>(t, null, null, null);
        } else {
            addNode(root, t);
        }

        size++;
        return true;
    }

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

    public T remove(T t) {

        Node node = getNode(root, t);
        if (node == null) {
            return null;
        }

        T result = (T) node.item;

        return result;
    }

    public boolean contains(T t) {
        return getNode(root, t) != null;
    }

    public int size() {
        return size;
    }

    public Iterator iterator() {
        return new Iterator() {
            Stack<Node> stack = new Stack<>();
            Node top = root;

            {
                while (top.leftNode != null) {
                    top = top.leftNode;
                }

                while (top != null || !stack.empty()) {

                }
            }

            @Override
            public boolean hasNext() {
                return !stack.empty();
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

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
