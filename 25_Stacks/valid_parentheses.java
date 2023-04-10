import java.util.*;
public class valid_parentheses {
    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
                }
                else {
                    if(stack.isEmpty()){
                        return false;
                        }
                    if((stack.peek()=='(' && ch== ')' )||( stack.peek()=='{' && ch== '}') || (stack.peek()=='[' && ch== ']')) {
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
    }
    if(stack.isEmpty()){
        return true;
    }
    else{
        return false;
    }
    }
    public static void main(String[] args) {
        String str="({}{}[]";
        System.out.println(isValid(str));


    }
    
}
