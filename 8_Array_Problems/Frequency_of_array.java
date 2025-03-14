
import java.util.Scanner;

public class Frequency_of_array {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int[] frequencyArray = calculateFrequency(array);

        System.out.println("Frequency of each element:");
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {    
            System.out.println(i + ": " + frequencyArray[i]);
            }
        }

        }

        public static int[] calculateFrequency(int[] array) {
        int maxElement = 0;
        for (int element : array) {
            if (element > maxElement) {
            maxElement = element;
            }
        }

        int[] frequencyArray = new int[maxElement + 1];

        for (int element : array) {
            frequencyArray[element]++;
        }

        return frequencyArray;
        }
    }

