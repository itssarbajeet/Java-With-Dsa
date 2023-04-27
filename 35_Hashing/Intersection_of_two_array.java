import java.util.*;
public class Intersection_of_two_array {
    public static void main(String args[]){
        int num1[]={7,3,9,6,2,4};
        int num2[]={3,7,9,8};
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<num1.length;i++){
            set.add(num1[i]);
        }
        int count =0;
        for(int j=0;j<num2.length;j++){
            if((set.contains(num2[j]))){
                set.remove(num2[j]);

                count++;
            }
        }
        
        System.out.println("Ans = "+set.size()+" ");
    
    }
}
