import java.util.*;
import javax.management.relation.Role;
public class minimum_Distance_Between_two_nodes {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node lca2(Node root,int n1,int n2){
        
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node leftLca=lca2(root.left,n1,n2);
        Node rightLca=lca2(root.right,n1,n2);
        // leftLca=val and rightLca=null
        if(rightLca==null){
            return leftLca;
        }
        // rightLca=val and leftLca=null
        if(leftLca==null){
            return rightLca;
        }
        // both leftLca and rightLca are not null
        return root;
    }
    public static int LcaDist(Node root,int n){
        if(root==null){
            return -1;
            }
        if(root.data==n){
            return 0;
        }
        int leftDist=LcaDist(root.left, n);
        int rightDist=LcaDist(root.right, n);

        if(leftDist==-1 && rightDist ==-1){
            return -1;
        }  
        else if(leftDist==-1){
            return rightDist+1;
        }
        else{
            return leftDist+1;
        }
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = LcaDist(lca, n1);
        int dist2 = LcaDist(lca, n2);
        return dist1 + dist2;
    }
    public static void main(String[] args) {
        /*    1
            /   \
          2       3
        /  \    /  \
       4    5  6    7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4, n2 = 5;
        System.out.println(minDist(root, n1, n2));
    }
}
