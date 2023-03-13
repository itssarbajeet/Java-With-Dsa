import java.util.*;
class Main {
    public static void name(int numbers[]) {
        int i = 0,j=numbers.length-1;
        while (i<=j) {
            numbers[i]=numbers[i]^numbers[j];
            numbers[j]=numbers[i]^numbers[j];
            numbers[j]=numbers[i]^numbers[j];
            i++;
            j--;
    }
    for (int k = 0; i < numbers.length; i++) {
        System.out.print(numbers[i] + " ");
    }}
public static void main(String[] args) {
int arr[]={1,2,3,4,5};
name(arr);
}
}