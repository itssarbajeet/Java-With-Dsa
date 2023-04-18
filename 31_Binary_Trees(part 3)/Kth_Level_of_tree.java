import java.util.*;

public class Kth_Level_of_tree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    
}
public static void KLevel(Node root,int level,int K_level){
    if(root==null){
        return;
    }
    if(level==K_level){
        System.out.print(root.data+" ");
        return;
    }
    KLevel(root.left,level+1,K_level);
    KLevel(root.right,level+1,K_level);

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
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.right.left=new Node(6);
    root.right.right=new Node(7);
    int k_level=3;
    KLevel(root,1,k_level);
}
}
