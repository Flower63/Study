package runnable.visitor;

import java.util.Queue;

/**
 * Created by Dennis
 *
 * on 12/18/2015.
 */
public interface Visitor {
    void enroll(Queue<Student> q);
}
