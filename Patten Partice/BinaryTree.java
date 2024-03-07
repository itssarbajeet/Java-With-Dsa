import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    Scanner sc = new Scanner(System.in);

    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    public static Node root1;

    public void insertion(int a) {
        System.out.println("Enter the root node: ");
        int val = sc.nextInt();
        root1 = new Node(val);
        insertion(root1);
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node currNode = q.remove();
                System.out.print(currNode.value + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            System.out.println();
        }
    }

    public void insertion(Node root) {
        System.out.println("Do you want to enter the left of " + root.value + "? (1 for Yes, 0 for No)");
        int leftChoice = sc.nextInt();
        if (leftChoice == 1) {
            System.out.println("Enter the value: ");
            int val = sc.nextInt();
            root.left = new Node(val);
            insertion(root.left);
        }
        System.out.println("Do you want to enter the right of " + root.value + "? (1 for Yes, 0 for No)");
        int rightChoice = sc.nextInt();
        if (rightChoice == 1) {
            System.out.println("Enter the value: ");
            int val = sc.nextInt();
            root.right = new Node(val);
            insertion(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insertion(5);
        tree.levelOrder(root1);
    }
}
