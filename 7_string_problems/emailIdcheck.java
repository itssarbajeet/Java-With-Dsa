import java.util.Scanner;

public class emailIdcheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine().toLowerCase();
        System.out.print("Set your password: ");
        String password = scanner.nextLine();
        int attempts = 3;
        boolean check = false;
        while (attempts > 0 && !check) {
            System.out.print("Enter your email: ");
            String inputEmail = scanner.nextLine().toLowerCase();
            System.out.print("Enter your password: ");
            String inputPassword = scanner.nextLine();

            if (email.equals(inputEmail) && password.equals(inputPassword)) {
                System.out.println("Login successful!");
                check = true;
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Wrong password. You have " + attempts + " attempts left.");
                } else {
                    System.out.println("Wrong password. No attempts left.");
                }
            }
        }

        if (!check) {
            System.out.println("Login failed.");
        }
    }
}