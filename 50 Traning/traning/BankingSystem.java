

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        Runnable withdrawTask = () -> account.withdraw(50);

        for (int i = 0; i < 5; i++) {
            new Thread(withdrawTask, "User" + i).start();
        }
    }
}