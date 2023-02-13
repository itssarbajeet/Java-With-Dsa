import java.util.*;

public class EvenOrOdd {
    public static String evenOrOdd(int num) {
        if ((num & 1) == 1) {
            return "odd";
        } else {
            return "even";
            
        }
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = obj.nextInt();
        
        System.out.println("The entered number " + num + " is " + evenOrOdd(num));
    }
}
