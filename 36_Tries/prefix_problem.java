import java.util.*;

public class prefix_problem {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq = 0;
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
            cur.freq++;
        }
        cur.eow = true;
    }

    public static void findPrefix(Node node, String prefix) {
        if (node == null) {
            return;
        }
        if (node.freq == 1) {
            System.out.print(prefix+" ++++");
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char ch = (char) (i + 'a');
                findPrefix(node.children[i], prefix + ch);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "hi", "hey", "how", "are", "you"};
        for (String word : words) {
            insert(word);
        }
        root.freq = -1;
        findPrefix(root, "");
    }
}
