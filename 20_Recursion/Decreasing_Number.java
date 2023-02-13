import java.util.*;
public class Decreasing_Number {
    public static void Decresing_number1(int n) {
        if (n ==  1 ) {
            System.out.print(n);
            return;
        } 
        System.out.print(n + " ");
        Decresing_number1(n - 1);
        }
    public static void main(String[] args) {
        int n = 5;
        Decresing_number1(n);
    }
}
