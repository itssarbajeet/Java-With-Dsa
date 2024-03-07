import java.util.*;

import javax.swing.text.PlainDocument;
public class LinkedList {
    //constructor
    public static class Node {
        int data;
        Node next;
        
            Node(int data) {
            this.data = data;
            this.next = null;
        }}
        //end of constructor
        //declaratiion of the head and tail
    public static Node head;
    public static Node tail;
    // the size is used to 
    static int size=0;
    
    // Adding element at the first index of the LinkedList
    public void addFirst(int data) {
        // step 1- Create new node
        Node newNode = new Node(data);
        size++;
        // Base case
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 2- Make head point to new node
        newNode.next = head;
        // step 3- make head=newNode
        head = newNode;
    }
    // Adding element at the last index of the LinkedList
    public void addLast(int data) {
        // step 1- Create new node
        Node newNode = new Node(data);
        size++;
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
    // Adding elements In any index of the LinkedList
    public void addInMiddle(int index, int data) {
        // base case
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    // printing element of the LinkedList
    public void print() {
        // base case
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void sizeOfLL(){
        System.out.print(size +"\n ");
    }
    public int RemoveFirst(){
        // Base Case
        if(size==0){
            System.out.println(" LinkedList is empty");
            return Integer.MAX_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    // this will remove the last element of the linked List
    public int RemoveLast(){
        // Base Case
        if(size==0){
            System.out.println(" LinkedList is empty");
            return Integer.MAX_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node temp = head;
        int i = 0;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }
    //Loop Method To Search
    public static int searchUsingLoop(int target){
        int i=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==target){
                return i-1;
            }
            temp=temp.next;
            i++;
        }
        return -1;

    }
    // called the search method for loop 
    public static void searchLoop(int target){
        int c=searchUsingLoop(target);
        System.out.println(c);
    }
    //Recursion Method To Search
    public static int searchUsingRecursion(int target,Node head){
        if(head==null){
            return -1;
        }
        else if(head.data==target){
            return 0;
        }
        int index=searchUsingRecursion(target, head);
        if(index==-1){
            return-1;
        }
        return index+1;
    }
    // called the search method for Recursion
    public static void searchRecursion(int target){
        int c=searchUsingLoop(target);
        System.out.println(c);
    }
    //Reverse the linked list
    public static void reverse() {
        Node prev=null;
        Node current=tail=head;
        Node next;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    //Remove Nth node from the end
    public void deleteNthFromTheEnd(int n){
        //Calculate the size 
        int length=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        size--;
        if(n==length){ //Remove first
            head=head.next;  
            return;
        }
        int i=1;
        int iToFind=length-n;//formula to get the indext from the nth last element
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            length++;
        }
        prev.next=prev.next.next; //this is that it will skip the one which one will be removed
        return;
    }
    //public Find the mid of the given linkedList
    public Node findMid(Node head){
        //step 1 Fast Slow Method To find the mid 
        Node slow=head;
        Node Fast=head;
        while(Fast!=null && Fast.next!=null){
            slow=slow.next; //+1
            Fast=Fast.next.next; //+2
        }
        return slow;
    }
    public boolean Check_palindrome(){
        //Check if the linked list is palindrome or not
        if(head==null || head.next==null){
            return true;
        }
        Node midNode=findMid(head);
        Node prev=null;
        Node current=midNode;
        Node next;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
            Node right =prev;
            Node left=head;
            while(right!=null){
                if(left.data!=right.data){
                    return false;
                }
                left =left.next;
                right=right.next;
            }
            return true;
    }
    //using the above return type the  print palindrome or not
    public void palindrome(){
        if(Check_palindrome()){
            System.out.println("yes this is a palindrome LinkedList");
        }
        else{
            System.out.println("This is a not a palindrome LinkedList");
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(0);
        ll.addInMiddle(10, 1);
        ll.addFirst(9);
        ll.print();
        ll.sizeOfLL();
        ll.RemoveFirst();
        ll.print();
        ll.sizeOfLL();
        ll.RemoveLast();
        ll.print();
        ll.sizeOfLL(); 
        ll.searchLoop(1);
        ll.searchRecursion(1);
        ll.reverse();
        ll.print();
        ll.deleteNthFromTheEnd(2);
        ll.print();  
        ll.palindrome(); 
    }
    public LinkedList.Node mergeSort(LinkedList.Node head2) {
        return null;
    }
}