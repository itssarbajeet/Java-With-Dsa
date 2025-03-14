public class bankaccount {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 10; i++) {
                account.withdraw(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}