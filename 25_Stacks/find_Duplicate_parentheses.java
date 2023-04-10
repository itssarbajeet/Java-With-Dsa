import java.util.*;

public class find_Duplicate_parentheses {
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                int count=0;
                while(stack.peek()!='(') 
                {
                stack.pop();
                count++;
                }
             
            if(count<1){
                return true;
            }
            else{
                stack.pop();
            }
            }
            else{
                stack.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "(((A+B)+(C+D)))";
        System.out.println(isValid(str));
    }
}
