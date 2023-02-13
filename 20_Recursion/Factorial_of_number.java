import java.util.*;
public class Factorial_of_number {
    public static void Factorial_of_number1(int n) {
        if (n ==  10 ) {
            System.out.print(n);
            return;
        } 
        System.out.print(n + " ");
        Factorial_of_number1(n + 1);
        }
    public static void main(String[] args) {
        int n = 0;
        Factorial_of_number1(n);
    }
}
