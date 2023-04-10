import java.util.*;
public class push_data_to_bottom_of_the_stack {
    class stack{
        public static void pushToButtom(Stack<Integer> s,int data){
            if(s.isEmpty()){
                s.push(data);
                return;
            }
            int top=s.pop();
            pushToButtom(s, data);
            s.push(top);
            }
        
    static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String args[]) {
        Stack<Integer> s =new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushToButtom(s,4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        }
    }
}
    

