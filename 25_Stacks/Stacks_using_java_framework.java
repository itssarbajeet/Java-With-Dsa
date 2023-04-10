import java.util.*;
public class Stacks_using_java_framework {
    static ArrayList<Integer> list=new ArrayList<>();
    public static boolean isEmpty(){
        return list.isEmpty();
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while(isEmpty()){
            System.out.println(stack.pop());
        }

    }
    
}
