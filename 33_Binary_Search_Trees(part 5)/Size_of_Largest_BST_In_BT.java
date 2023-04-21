import java.util.*;

import javax.print.DocFlavor.INPUT_STREAM;
public class Size_of_Largest_BST_In_BT {
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
    static class Info{
        boolean isBst;
        int max;
        int min;
        int size;
        public Info(boolean isBst,int min,int max,int size){
            this.isBst=isBst;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBst=0;

    public static Info largestBst(Node root){
        if(root==null){
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Info leftInfo=largestBst(root.left);
        Info rightInfo=largestBst(root.right);
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data,Math.min(rightInfo.min,leftInfo.min));
        int max=Math.max(root.data,Math.max(rightInfo.max,leftInfo.max));
        if(root.data<=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false,min,max,size);
        }


        if(leftInfo.isBst && rightInfo.isBst ){
            maxBst= Math.max(maxBst,size);

            return new Info(true, min, max, size);
        }
        return new Info(false,min,max,size);



    }
    public static void main(String[] args) {
        /*
                   50
                 /    \
                30     60
               /  \   /   \
              5   20  45    70
                           /  \
                         65    80

                   Given BST


         */
        Node root=new Node(50);
        root.left=new Node(30);
        root.left.left=new Node(5);
        root.left.right=new Node(20);
        root.right=new Node(60);
        root.right.left=new Node(45);
        root.right.right=new Node(70);
        root.right.right.left=new Node(65);
        root.right.right.right=new Node(80);

        /*
                        60
                       /   \
                     45    70
                          /  \
                         65    80

        expected BST
        */
        Info info= largestBst(root);
        System.out.println("largest BST size = "+ maxBst);

    }



}
