public class No_of_grid_ways_using_math_formula {
    public static int factorial(int n) {
        if (n == 1|| n==0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int noOfGridWays(int rows, int columns) {
        int numerator = factorial(rows + columns - 2);
        int denominator = factorial(rows - 1) * factorial(columns - 1);
        return numerator / denominator;
    }

    public static void main(String[] args) {
        int rows = 3, columns = 3;
        int ways = noOfGridWays(rows, columns);
        System.out.println("The number of ways to traverse a " + rows + " by " + columns + " grid is: " + ways);
    }
}
