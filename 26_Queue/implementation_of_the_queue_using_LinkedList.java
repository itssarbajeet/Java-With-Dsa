import java.util.*;

public class implementation_of_the_queue_using_LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head=null;
        static Node tail=null;

        // Checks if the queue is empty.
        public boolean isEmpty() {
            return (head == null);
        }

        // Adds an element to the tail of the queue.
        public void add(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        // Removes and returns the element at the head of the queue.
        public int remove() {
            if (head == null) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = head.data;

            if (head == tail) {
                tail=head = null;
            }
            else{
                head = head.next;
            }
            return front;
        }

        // Returns the element at the head of the queue without removing it.
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        // Add elements to the queue.
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        // Remove all elements from the queue and print them.
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
