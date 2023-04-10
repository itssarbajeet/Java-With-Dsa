import java.util.*;
public class reverse_a_String_using_stack {
    public static void reverseAString(Stack<Character> s) {
    if(s.isEmpty()) {
        return ;
    }
    char c = s.pop();
    System.out.print(c);
    reverseAString(s);
    
}
public static void main(String[] args) {
    Stack<Character> s = new Stack<>();
    s.push('a');
    s.push('b');
    s.push('c');
    s.push('d');
    s.push('e');
    reverseAString(s);
}}
