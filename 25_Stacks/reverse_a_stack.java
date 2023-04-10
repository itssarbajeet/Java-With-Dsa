import java.util.*;
public class reverse_a_stack {
    public static void pushToButtom(Stack<Character> s, char data) {
    if (s.isEmpty()) {
        s.push(data);
        return;
    }
    char top = s.pop();
    pushToButtom(s, data);
    s.push(top);
}
public static void printStack(Stack<Character>s){
    while(!s.isEmpty()){
        System.out.print(s.pop());
    }
}

    public static void reverseAString(Stack<Character> s) {
    if(s.isEmpty()) {
        return ;
    }
    char top = s.pop();
    reverseAString(s);
    pushToButtom(s, top);
    
}
public static void main(String[] args) {
    Stack<Character> s = new Stack<>();
    s.push('a');
    s.push('b');
    s.push('c');
    s.push('d');
    s.push('e');
    reverseAString(s);
    printStack(s);


}}

