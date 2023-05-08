public class MergeSortLinkedList {

    //Represent a node of the singly linked list
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;

    //addNode() will add a new node to the list
    public void addNode(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //Checks if the list is empty
        if (head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
    }

    //mergeSort() will sort the linked list using Merge Sort Algorithm
    public void mergeSort() {
        head = mergeSort(head);
    }

    private Node mergeSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node middle = getMiddle(node);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(node);
        Node right = mergeSort(nextOfMiddle);
        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Node result;
        if (left.data < right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //display() will display all the nodes present in the list
    public void display() {
        //Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            //Prints each node by incrementing pointer
            if (current.next != null) {
                System.out.print(current.data + "-> ");
            } else {
                System.out.print(current.data);
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MergeSortLinkedList sList = new MergeSortLinkedList();

        //Adds data to the list
        sList.addNode(9);
        sList.addNode(7);
        sList.addNode(2);
        sList.addNode(5);
        sList.addNode(4);

        //Displaying original list
        System.out.println("Original list: ");
        sList.display();

        //Sorting list
        sList.mergeSort();

        //Displaying sorted list
        System.out.println("Sorted list: ");
        sList.display();
    }
}
