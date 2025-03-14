import java.io.*;
import java.util.*;

public class ExpenseSplitter {

    static class Person {
        String name;
        Map<Integer, Double> balances = new HashMap<>();

        public Person(String name, int totalPersons) {
            this.name = name;
            for (int i = 1; i <= totalPersons; i++) {
                balances.put(i, 0.0);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();

        System.out.print("Enter the number of people: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numPeople; i++) {
            System.out.print("Enter the name of person " + i + ": ");
            String name = scanner.nextLine();
            persons.add(new Person(name, numPeople));
        }    

        try (BufferedWriter balanceWriter = new BufferedWriter(new FileWriter("balance.txt"));
             BufferedWriter settlementWriter = new BufferedWriter(new FileWriter("settlement.txt"))) {

            int transactionCount = 1;
            while (true) {
                System.out.print("Enter the amount (Press 0 to exit): ");
                double amount = scanner.nextDouble();
                if (amount == 0) break;

                // Ask who paid
                System.out.println("Who paid the amount?");
                for (int i = 0; i < numPeople; i++) {
                    System.out.println((i + 1) + ". " + persons.get(i).name);
                }
                int payerIndex = scanner.nextInt() - 1;

                System.out.print("Paid for how many persons? ");
                int paidForCount = scanner.nextInt();

                Set<Integer> paidForIndices = new HashSet<>();
                if (paidForCount == numPeople) {
                    for (int i = 0; i < numPeople; i++) {
                        paidForIndices.add(i);
                    }
                } else {
                    System.out.println("Enter the numbers of the persons who were paid for:");
                    for (int i = 0; i < numPeople; i++) {
                        System.out.println((i + 1) + ". " + persons.get(i).name);
                    }
                    for (int i = 0; i < paidForCount; i++) {
                        int index = scanner.nextInt() - 1;
                        paidForIndices.add(index);
                    }
                    
                }

                double splitAmount = amount / paidForCount;
                balanceWriter.write("Transaction " + transactionCount + ":\n");
                for (int index : paidForIndices) {
                    if (index != payerIndex) {
                        balanceWriter.write(splitAmount + " will be paid to " + persons.get(payerIndex).name + " by " + persons.get(index).name + "\n");
                        persons.get(index).balances.put(payerIndex + 1, persons.get(index).balances.get(payerIndex + 1) + splitAmount);
                    }
                }
                balanceWriter.write("\n");
                transactionCount++;
            }
            settlementWriter.write("Settlement Summary:\n");
            for (int payer = 1; payer <= numPeople; payer++) {
                for (int payee = 1; payee <= numPeople; payee++) {
                    double amount = persons.get(payee - 1).balances.get(payer);
                    if (amount != 0) {
                        settlementWriter.write(amount + " will be paid to " + persons.get(payer - 1).name + " by " + persons.get(payee - 1).name + "\n");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Transactions saved to balance.txt and settlement.txt.");
    }
}
