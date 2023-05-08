import java.util.*;

public class remove_Cycle_from_LL {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // cycle exist
            }
        }
        return false; // cycle does not exist
    }

    public static void removeCycle(Node head) {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        Node prev = null;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
    
        if (cycle == false) {
            return;
        }
    
        // finding meeting point
        slow = head;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
    
        // remove cycle -> last.next = null
        prev.next = null;
    }
    
    public static void main(String args[]) {
        Node head = new Node(1);
        Node temp=new Node (2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp; // cycle created: 1->2->3->2

        System.out.println(isCycle(head));
        removeCycle(head);
        System.out.println(isCycle(head));
    }
}
