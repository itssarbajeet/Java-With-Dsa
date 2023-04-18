import java.util.*;

import javax.sound.midi.MidiDevice.Info;
public class longest_dirameter_of_A_Tree_Optimized_method {
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
public static int sum(Node root){
    if(root==null){
        return 0;
    }
    int leftSum=sum(root.left);
    int rightSum=sum(root.right);
    return leftSum+rightSum+root.data;
}
    static class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
           this.diam=diam;
           this.ht=ht; 
        }
    }
    public static Info longest_diameter(Node root){
        if(root==null){
            return new Info(0,0);
        } 
        Info leftInfo=longest_diameter(root.left);
        Info rightInfo=longest_diameter(root.right);
        int diam=Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+ rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);



        
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

        System.out.println(longest_diameter(root).diam); 


    }
    
}
