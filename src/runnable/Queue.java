package runnable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Flower on 12/11/2015.
 */
public class Queue {

    private LinkedList<Integer> list = new LinkedList<>();
    private int limit = 10;

    public synchronized void push(Integer val) {
        while (list.size() >= limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(val);

        notify();
    }

    public synchronized Integer pop() {
        while (list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer temp = list.pop();

        notify();

        return temp;
    }
}
