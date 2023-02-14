//Time complexity is O(LOG(n))
import java.util.*;
public class Optimized_power_of_any_no {
    public static int Optimized_power_of_any_no(int no,int pow){
        
        if (pow == 0){
            return 1;
        }
        int half=Optimized_power_of_any_no(no, pow/2);
        int result=half*half;
        if(pow%2!=0){
            return no*result;
        }
        return  result;
    }
    public static void main(String[] args) {
        int no=5;
        int pow=4;
        System.out.println("the ans is "+Optimized_power_of_any_no(no, pow));
}}

