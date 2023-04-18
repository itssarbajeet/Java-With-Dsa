import java.util.*;
public class subtree_of_Another_Tree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
        public static boolean isIdentical(Node node, Node subroot) {
    if(node == null && subroot == null) {
        return true;
    } else if(node == null || subroot == null || node.data != subroot.data) {
        return false;
    }
    if(!isIdentical(node.left, subroot.left)) {
        return false;
    }
    if(!isIdentical(node.right, subroot.right)) {
        return false;
    }
    return true;
}

        public static boolean isSubTree(Node root,Node subRoot){
            if(root==null){
                return false;
            }
            if(root.data==subRoot.data||subRoot==null){
                if(isIdentical(root,subRoot)){
                    return true;
                }
            
            /*
            return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot) 
            as per the rule if it gets the same subtree in left then it will directly return 
            true and will not execute right 
            OR
            it will check right this is the advantages of using this return direct
             */
            

            }
            boolean leftAns=isSubTree(root.left, subRoot); 
            boolean rightAns=isSubTree(root.right, subRoot);
            return leftAns || rightAns;

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
        root.right.right.right=new Node(8);

        /*
                   2
                 /   \ 
                4     5
        */

        //subTree 
        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);
        System.out.println(isSubTree(root, subRoot)); 


    }
    
}}
