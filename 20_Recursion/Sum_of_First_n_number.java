import java.util.*;
public class Sum_of_First_n_number {
    public static int Sum_of_First_n_number1(int n){
        if(n==0){
            return 0;
        }
        else{
            return n+Sum_of_First_n_number1(n-1);
        }}
        public static  void main(String[] args) {
            int n=10;
            System.out.println(Sum_of_First_n_number1(n));

    }}
    


    