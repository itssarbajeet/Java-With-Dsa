import java.util.*;
import java.util.LinkedList;
public class stack_using_2_queue_push_method {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    // method to add an element to the stack
    public void push(int data) {
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        // Add the new element to q1
        q1.add(data);
        // Move all elements back from q2 to q1
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }
    // method to remove and return the top element of the stack
    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException();
        }
        return q1.remove();
    }
    // method to return the top element of the stack without removing it
    public int peek() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException();
        }
        return q1.peek();
    }
    // method to check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    public static void main(String[] args) {
        // create a new instance of the stack
        stack_using_2_queue_push_method stack = new stack_using_2_queue_push_method();
        // add some elements to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // remove and print all elements of the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
