import java.util.LinkedList;
public class zig_zag_LinkedList {

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

    
    public void zigzag(){
        //find the mid
        Node slow=head;
        Node fast=head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node mid=slow;
        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while(curr!=null){
            next =curr.next;
            curr.next=prev;
            prev = curr;
            curr=next;
        }
    Node left=head;
    Node rigth=prev;
    Node nextL,nextR;

    //alt merge -zig-zag merge
    while(left !=null && rigth !=null){
        nextL =left.next;
        left.next=rigth;
        nextR=rigth.next;
        rigth.next=nextL;
        rigth=nextR;
        left=nextL;


    }
}
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
public void addLast(int data) {
    // step 1- Create new node
    Node newNode = new Node(data);
    // Base case
    if (head == null) {
        head = tail = newNode;
        return;
    }
    // step 2- Make tail.next point to new node
    tail.next = newNode;
    // step 3- make tail=newNode
    tail = newNode;
}

    public static void main(String[] args) {

        zig_zag_LinkedList sList = new zig_zag_LinkedList();

        //Adds data to the list
        sList.addLast(9);
        sList.addLast(7);
        sList.addLast(2);
        sList.addLast(5);
        sList.addLast(4);

        //Displaying original list
        System.out.println("Original list: ");
        sList.display();
        sList.zigzag();
        sList.display();
    }
}
