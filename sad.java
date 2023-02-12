public class sad {
    public static void main(String[] args) {
        int n = 5; // size of the pattern
        palindrome(n);
    }

    public static void palindrome(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i) {
                    System.out.print(j + " ");
                } else {
                    System.out.print(n - j + 1 + " ");
                    
                }
            }
            System.out.println();
        }
    }
}
