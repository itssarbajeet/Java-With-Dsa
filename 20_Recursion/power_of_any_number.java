//Time complexity is O(LOG(n))
import java.util.*;
public class power_of_any_number {
    public static int power_of_any_number1(int number,int toPower){
        if(toPower==0){
            return 1;}
        int pro=(int) Math.pow(number, toPower-1);
        return number*pro;}
    public static  void main(String[] args) {
        int num=5;
        int topow=3;
        System.out.println(power_of_any_number1(num, topow));}}