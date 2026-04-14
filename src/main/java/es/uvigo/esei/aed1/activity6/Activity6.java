
package es.uvigo.esei.aed1.activity6;

import static java.util.Objects.requireNonNull;

import es.uvigo.esei.aed1.activity6.implementation.CustomQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Activity6 {

    // Exercise 1.1
    public static <T> void concat(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {

    }

    // Exercise 1.2
    public static <T> Queue<T> mix(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {
        return null;
    }

    // Exercise 2
    public static <T> Queue<T> copy(Queue<T> queue) throws NullPointerException {
        return null;
    }

    // Exercise 3
    public static Queue<Integer> mixInOrderly(Queue<Integer> queue1, Queue<Integer> queue2)
            throws NullPointerException {
        return null;
    }

    // Exercise 4
    public static <T> void moveToFront(Queue<T> queue, T value) throws NullPointerException {

    }

    // Exercise 5
    public static Integer josephus(Queue<Integer> soldiers, int initialPos, int jump) {
        return 0;
    }

    // Ejercicio 6
    public static <T> boolean equalsValues(CustomQueue<T> queue) throws NullPointerException {
        requireNonNull(queue);

        T element;
        boolean isEqual = true;
        
        for (int j = 0; j < queue.size(); j++) {
            element = queue.remove();
            if (!queue.first().equals(element) && isEqual) {
                isEqual = false;
            }
            queue.add(element);
            
        }

        return isEqual;
    }

}
