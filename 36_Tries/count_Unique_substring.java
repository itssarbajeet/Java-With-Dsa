import java.util.*;
public class count_Unique_substring {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; //end of word
        
        
            Node() {
                for(int i=0; i<26; i++) {
                    children[i] = null;
                }
            }
        }
    public static Node root = new Node();
    public static void insert(String word) {
        Node curr = root;
        for(int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    

        
    public static boolean search(String key) {
        Node curr = root;
        for(int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false; 
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;   
    }
    public static int countNode(Node root){
        if(root==null){
        return 0;
    }
    int count = 0;
    for(int i=0; i<26; i++){
        if(root.children[i] !=null){
            count += countNode(root.children[i]);
        }



    }
    return count+1;
}


    public static void main(String args[]) {
        String str="apple ";
        //suffix -> insert in trie
        for(int i=0;i<str.length();i++){
            insert(str.substring(i));  
        }


       System.out.println(countNode(root)); 
    }
    
    
    
}
