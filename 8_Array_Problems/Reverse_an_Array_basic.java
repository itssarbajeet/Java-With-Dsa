import java.util.*;
class Main {
    public static void name(int numbers[]) {
        int Arr1[] = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            Arr1[numbers.length - 1 - i] = numbers[i];
        }
        for (int i = 0; i < Arr1.length; i++) {
            System.out.print(Arr1[i] + " ");
        }
    }
public static void main(String[] args) {
int arr[]={1,2,3,4,5};
name(arr);
}
}