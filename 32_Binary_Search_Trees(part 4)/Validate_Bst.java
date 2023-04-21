import java.util.*;
public class Validate_Bst {
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
    public static void preOrder(Node root){
        if(root == null) {
             return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);

}

    public static Node createMirror(Node root){
        if(root == null){
            return null;
        }
        Node left = createMirror(root.left);
        Node right = createMirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        /*    8
            /   \
          5       10
        /  \       \
       3    6      11
         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(11);
        root= createMirror(root);
        preOrder(root);
        System.out.println();

    }
}
