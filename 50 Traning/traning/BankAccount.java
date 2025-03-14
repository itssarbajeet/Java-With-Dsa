class BankAccount {
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