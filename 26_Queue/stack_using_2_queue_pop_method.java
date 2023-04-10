import java.util.*;
import java.util.LinkedList;


public class stack_using_2_queue_pop_method {

    public static class Stack {
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        // method to add an element to the stack
        public void push(int data) {
            // add the new element to the non-empty queue
            if (!queue1.isEmpty()) {
                queue1.add(data);
            } else {
                queue2.add(data);
            }
        }

        // method to remove and return the top element of the stack
        public int pop() {
            // check if both queues are empty
            if (queue1.isEmpty() && queue2.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }

            // move all but the last element from the non-empty queue to the other queue
            Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
            Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

            while (nonEmptyQueue.size() > 1) {
                emptyQueue.add(nonEmptyQueue.remove());
            }

            // remove and return the last element from the non-empty queue
            return nonEmptyQueue.remove();
        }

        // method to return the top element of the stack without removing it
        public int peek() {
            // check if both queues are empty
            if (queue1.isEmpty() && queue2.isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }

            // move all but the last element from the non-empty queue to the other queue
            Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
            Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;

            while (nonEmptyQueue.size() > 1) {
                emptyQueue.add(nonEmptyQueue.remove());
            }

            // get the last element from the non-empty queue and add it to the other queue
            int top = nonEmptyQueue.peek();
            emptyQueue.add(nonEmptyQueue.remove());
            return top;
        }

        // method to check if the stack is empty
        public boolean isEmpty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }


    }

    public static void main(String[] args) {
        // create a new instance of the stack
        Stack stack = new Stack();

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
