import java.util.LinkedList;
import java.util.*;
public class Queue_using_java_Framework {
    


    public static void main(String[] args) {
        // Create a new queue
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        // Remove all elements from the queue and print them
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}


