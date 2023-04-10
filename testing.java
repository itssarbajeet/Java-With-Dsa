import java.util.*;

public class testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] arr = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                arr[j] = scanner.nextInt();
            }
            if (isValid(arr)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static boolean isValid(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
