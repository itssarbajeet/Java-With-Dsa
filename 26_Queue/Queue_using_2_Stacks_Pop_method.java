import java.util.*;

public class Queue_using_2_Stacks_Pop_method {

    public static class Queue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // method to add an element to the queue
        public void push(int data) {
            // Add the new element to stack1
            stack1.push(data);
        }

        // method to remove and return the front element of the queue
        public int pop() {
            // Move all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            // Get the front element from stack2
            int front = stack2.pop();

            // Move all elements back from stack2 to stack1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            return front;
        }

        // method to return the front element of the queue without removing it
        public int peek() {
            // Move all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            // Get the front element from stack2
            int front = stack2.peek();

            // Move all elements back from stack2 to stack1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            return front;
        }

        // method to check if the queue is empty
        public boolean isEmpty() {
            return stack1.isEmpty();
        }

        // method to return the size of the queue
        public int size() {
            return stack1.size();
        }
    }

    public static void main(String[] args) {
        // create a new instance of the queue
        Queue queue = new Queue();

        // add some elements to the queue
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        // remove and print all elements of the queue
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
}
