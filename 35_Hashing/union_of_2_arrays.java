import java.util.*;
public class union_of_2_arrays {
    public static void main(String args[]){
        int num1[]={7,3,9,6,2,4};
        int num2[]={3,4};
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<num1.length;i++){
            set.add(num1[i]);
        }
        for(int i=0;i<num2.length;i++){
            set.add(num2[i]);
        }
        System.out.println("Ans = "+set.size()+" "+set);
    
    }
}
