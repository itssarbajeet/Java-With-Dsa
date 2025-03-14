public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds.");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);

        Runnable withdrawTask = () -> account.withdraw(50);

        for (int i = 0; i < 5; i++) {
            new Thread(withdrawTask, "User" + i).start();
        }
    }
} 
