import java.util.*; //O(n) - TC
public class convert_Bst_to_Balnced_Bst {
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

    public static Node createBst(ArrayList<Integer> inorder, int start, int end){
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBst(inorder, start, mid - 1);
        root.right = createBst(inorder, mid + 1, end);
        return root;
    }
    public static void getInOrder(Node root,ArrayList<Integer> inorder){
        if(root == null) {
            return;
        }
        getInOrder(root.left,inorder);
        inorder.add(root.data);
        getInOrder(root.right,inorder); 
    }
    public static Node balancedBST(Node root){
        //inorder
        ArrayList<Integer> inorder =new ArrayList<>();
        getInOrder(root,inorder);

        
        //sorted inorder -> balanced BST
        root =createBst(inorder,0,inorder.size()-1);
        return root;




    }

     
}
