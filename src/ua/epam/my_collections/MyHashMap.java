package ua.epam.my_collections;

/**
 * Custom HashMap implementation
 *
 * @author Dennis
 *
 * on 12/4/2015.
 */
@SuppressWarnings("unchecked")
public class MyHashMap<T, E> {

    private int capacity = 15;
    private int size;
    private Node<T, E>[] buckets = new Node[capacity];

    private final static int EXTENSIVE_THRESHOLD = Integer.MAX_VALUE >> 1;
    private final static double LOAD_FACTOR = 0.75;

    /**
     * Adding key and value to map
     *
     * @param key Key
     * @param value Value
     */
    public void put(T key, E value) {
        checkLoad();

        Node<T, E> node = findNode(key);

        if (node != null) {
            node.value = value;
        } else {
            add(new Node<>(key, value));
            size++;
        }
    }

    /**
     * Getting value from map by specified key
     *
     * @param key Key associated with value
     * @return Value, that associated with specified key, or <b>null</b> if such value not found
     */
    public E get(T key) {
        Node<T, E> node = findNode(key);

        if (node == null) {
            return null;
        }

        return node.value;
    }

    /**
     * Removing key-value pair by specified key
     *
     * @param key Key to find associated value
     * @return Value, associated with specified key
     */
    public E remove(T key) {
        Node<T, E> node = findNode(key);

        if (node == null) {
            return null;
        }

        int buckNum = getBucketNumber(key);
        E value = node.value;

        if (buckets[buckNum] == node && node.next == null) {
            // if node alone in bucket
            buckets[buckNum] = null;

        } else if (node.next == null) {
            Node<T, E> temp = buckets[buckNum];

            while (temp.next != node) {
                temp = temp.next;
            }

            temp.next = null;

        } else {
            // copy next node into present
            while (node.next != null) {
                node.key = node.next.key;
                node.value = node.next.value;

                // storing current position
                Node<T, E> temp = node.next;

                node.next = node.next.next;
                node = temp;
            }
        }

        size--;
        return value;
    }

    public int size() {
        return size;
    }

    /**
     * Finding node by key
     *
     * @param key Key to find node by hash code and equals method
     * @return Node that contains specified key of <b>null</b> if key not found
     */
    private Node<T, E> findNode(T key) {
        Node<T, E> node = buckets[getBucketNumber(key)];

        while (node != null && !node.key.equals(key)) {
            node = node.next;
        }

        return node;
    }

    /**
     * Getting bucket number
     *
     * @param key Key to calculate hash code
     * @return Bucket number
     */
    private int getBucketNumber(T key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Adding node
     *
     * @param node Node to add
     */
    private void add(Node<T, E> node) {
        int buckNum = getBucketNumber(node.key);

        Node bucket = buckets[buckNum];

        if (bucket == null) {
            buckets[buckNum] = node;
            return;
        }

        while (bucket.next != null) {
            bucket = bucket.next;
        }

        bucket.next = node;
    }

    /**
     * Checking map load against load factor
     */
    private void checkLoad() {

        if (capacity == Integer.MAX_VALUE) {
            return;
        }

        /*
         * Calculating load
         */
        double load = 0;
        for (Node node : buckets) {
            if (node != null) {
                load++;
            }
        }

        if ((load / capacity) > LOAD_FACTOR) {
            extend();
        }
    }

    /**
     * Extending array of buckets
     */
    private void extend() {
        /*
         * Extending capacity
         */
        if (capacity < EXTENSIVE_THRESHOLD) {
            capacity <<= 1;
        } else {
            capacity = Integer.MAX_VALUE;
        }

        /*
         * Creating new array
         */
        Node<T, E>[] oldBuckets = buckets;
        buckets = new Node[capacity];

        /*
         * Adding nodes to new array
         */
        for (Node<T, E> node : oldBuckets) {
            while (node != null) {
                add(new Node<>(node.key, node.value));
                node = node.next;
            }
        }
    }

    // Debug purposes
    public void showNodes() {
        for (Node node : buckets) {
            if (node == null) {
                System.out.println("null");
            }

            while (node != null) {
                System.out.println("   " + node.key);
                System.out.println("   " + node.value);
                System.out.println();
                node = node.next;
            }

            System.out.println("------------");
        }
    }

    /**
     * Private inner class to hold entries
     */
    private static class Node<T, E> {
        private T key;
        private E value;
        private Node<T, E> next;

        /**
         * Constructor
         *
         * @param key Key
         * @param value Value
         */
        private Node(T key, E value) {
            this.key = key;
            this.value = value;
        }
    }
}
