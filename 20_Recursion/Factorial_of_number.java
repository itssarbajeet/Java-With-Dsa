import java.util.*;
public class Factorial_of_number {
    public static int Factorial_of_number1(int n) {
        if(n==0){
            return 1;
        }
        else{
            return n*Factorial_of_number1(n-1);

        }
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.print(Factorial_of_number1(n));
    }

}