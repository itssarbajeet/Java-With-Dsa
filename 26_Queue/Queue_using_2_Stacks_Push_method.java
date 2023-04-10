import java.util.*;

public class Queue_using_2_Stacks_Push_method {

Stack<Integer> stack1 = new Stack<>();
Stack<Integer> stack2 = new Stack<>();

// method to add an element to the queue
public void push(int data) {
    // Move all elements from stack1 to stack2
    while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
    }

    // Add the new element to stack1
    stack1.push(data);

    // Move all elements back from stack2 to stack1
    while (!stack2.isEmpty()) {
        stack1.push(stack2.pop());
    }
}

// method to remove and return the front element of the queue
public int pop() {
    return stack1.pop();
}

// method to return the front element of the queue without removing it
public int peek() {
    return stack1.peek();
}

// method to check if the queue is empty
public boolean isEmpty() {
    return stack1.isEmpty();
}

// method to return the size of the queue
public int size() {
    return stack1.size();
}

public static void main(String[] args) {
    // create a new instance of the queue
    Queue_using_2_Stacks_Push_method queue = new Queue_using_2_Stacks_Push_method();

    // add some elements to the queue
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    while (!queue.isEmpty()) {
        System.out.println(queue.pop());
    }
}
}
