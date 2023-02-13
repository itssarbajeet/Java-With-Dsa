import java.util.*;
public class Increasing_number {
    public static void Decresing_number1(int n) {
        if (n ==  10 ) {
            System.out.print(n);
            return;
        } 
        System.out.print(n + " ");
        Decresing_number1(n + 1);
        }
    public static void main(String[] args) {
        int n = 0;
        Decresing_number1(n);
    }
}
