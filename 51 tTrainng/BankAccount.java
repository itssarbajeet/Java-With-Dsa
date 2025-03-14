public class BankAccount {
    private int balance;
    public BankAccount(int amount) {
        this.balance = amount;
    }
    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed the withdrawal of " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but only " + balance + " is available.");
        }
    }
    public int getBalance() {
        return balance;
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 10; i++) {
                account.withdraw(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } };
        Thread user1 = new Thread(withdrawTask, "User1");
        Thread user2 = new Thread(withdrawTask, "User2");
        user1.start();
        user2.start();
    }
}