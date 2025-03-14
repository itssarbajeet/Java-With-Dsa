import java.io.IOException;
import java.util.Scanner;

public class ThrowExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive number: ");
        
        try {
            int number = scanner.nextInt();
            if (number < 0) {
                throw new IOException("Negative value entered");
            }
            System.out.println("You entered: " + number);
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
