import java.util.*;

public class Circular_Queue_Using_Array {
    static class Queue {
        int arr[];
        int front;
        int rear;
        int size;

        Queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return (front == -1 && rear == -1);
        }

        public boolean isFull() {
            return ((rear + 1) % size == front);
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            } else if (isEmpty()) {
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % size;
            }
            arr[rear] = data;
        }

        public int remove() {
            int data = -1;
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return data;
            } else if (front == rear) {
                data = arr[front];
                front = -1;
                rear = -1;
            } else {
                data = arr[front];
                front = (front + 1) % size;
            }
            return data;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        q.remove();
        q.add(6);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
