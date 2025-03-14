import java.util.Scanner;

class BankDetails {
    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private double accountBalance;

    public BankDetails(int accountNumber, String accountHolderName, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public int getAc() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: $" + accountBalance);
    }
}

public class Banking {
    private static BankDetails[] accounts;
    private static int count = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void createAccount() {
        if (count < accounts.length) {
            System.out.print("Enter Account Number: ");
            int accNum = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Account Holder Name: ");
            String accHolder = scanner.nextLine();
            System.out.print("Enter Account Type: ");
            String accType = scanner.nextLine();
            System.out.print("Enter Initial Balance: ");
            double accBalance = scanner.nextDouble();

            accounts[count] = new BankDetails(accNum, accHolder, accType, accBalance);
            count++;
            System.out.println("Account Created Successfully!\n");
        } else {
            System.out.println("Cannot create more accounts.\n");
        }
    }

    public static void displayAllAccounts() {
        if (count == 0) {
            System.out.println("No accounts available.\n");
            return;
        }
        for (int i = 0; i < count; i++) {
            accounts[i].displayDetails();
            System.out.println();
        }
    }

    public static void updateAccount() {
        System.out.print("Enter Account Number to Update: ");
        int accNum = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAc() == accNum) {
                System.out.print("Enter New Account Holder Name: ");
                String newAccHolder = scanner.nextLine();
                System.out.print("Enter New Account Type: ");
                String newAccType = scanner.nextLine();
                System.out.print("Enter New Balance: ");
                double newBalance = scanner.nextDouble();

                accounts[i].setAccountHolderName(newAccHolder);
                accounts[i].setAccountType(newAccType);
                accounts[i].setAccountBalance(newBalance);
                System.out.println("Account Updated Successfully!\n");
                return;
            }
        }
        System.out.println("Account Not Found.\n");
    }

    public static void readAccount() {
        System.out.print("Enter Account Number to Read: ");
        int accNum = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAc() == accNum) {
                accounts[i].displayDetails();
                System.out.println();
                return;
            }
        }
        System.out.println("Account Not Found.\n");
    }

    public static void searchAccount() {
        System.out.print("Enter Account Number to Search: ");
        int accNum = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAc() == accNum) {
                System.out.println("Account Found!\n");
                accounts[i].displayDetails();
                System.out.println();
                return;
            }
        }
        System.out.println("Account Not Found.\n");
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of accounts to create: ");
        int size = scanner.nextInt();
        accounts = new BankDetails[size];

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Update Account");
            System.out.println("4. Read Account");
            System.out.println("5. Search Account");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    displayAllAccounts();
                    break;
                case 3:
                    updateAccount();
                    break;
                case 4:
                    readAccount();
                    break;
                case 5:
                    searchAccount();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice! Try Again.\n");
            }
        }
    }
}
