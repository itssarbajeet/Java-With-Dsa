import java.util.*;
class Main {
    public static int name(int numbers[]) {
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += numbers[k];
                }
                max1 = Math.max(max1, sum);
            }
        }
        return max1;
    }
public static void main(String[] args) {
int arr[]={-5,2,-3,1,-8,4};
System.out.println("The MAximum subArray sum is : " +name(arr));
}
}
