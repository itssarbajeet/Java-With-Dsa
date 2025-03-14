package Santu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class pay {
    public static void main(String[] args) {
        int n;
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        n = obj.nextInt();
        obj.nextLine(); 

        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = obj.nextLine();
        }

        int[] total = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the payments for " + names[i] + ", enter 0 to finish:");
            int payment;
            do {
                System.out.print("Enter payment: ");
                payment = obj.nextInt();
                total[i] += payment;
            } while (payment != 0);
        }

        int total1 = 0;
        for (int i = 0; i < n; i++) {
            total1 += total[i];
        }
        double avg = (double) total1 / n;

        double[] total2 = new double[n];

        try {
            FileWriter payWriter = new FileWriter("pay1.txt");
            FileWriter getWriter = new FileWriter("get1.txt");
            FileWriter avgWriter = new FileWriter("avg1.txt");

            for (int i = 0; i < n; i++) {
                total2[i] = total[i] - avg;
                if (total2[i] > 0) {
                    getWriter.write(names[i] + " will get rupee  " + total2[i] + "\n");
                    System.out.println(names[i] + " will get rupee " + total2[i]);
                } else if (total2[i] < 0) {
                    payWriter.write(names[i] + " will pay rupee " + (-total2[i]) + "\n");
                    System.out.println(names[i] + " will pay rupee " + (-total2[i]));
                }
            }

            avgWriter.write("Average payment per person: rupee " + avg);
            avgWriter.close(); 

            payWriter.close();
            getWriter.close();
            System.out.println("Payment details written to pay1.txt and get1.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
