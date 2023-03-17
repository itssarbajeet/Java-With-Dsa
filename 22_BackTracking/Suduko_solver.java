public class Suduko_solver {
    private static final int rows_and_columns = 9;
    private static final int Grid_size = 3;
    private static final int NO_VALUE = 0;
    public static boolean solveSudoku(int[][] board) {
        int row = 0;
        int col = 0;
        boolean isEmpty = false;
        // Find an empty cell
        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    isEmpty = true;
                    break;
                }
            }
            if (isEmpty) {
                break;
            }
        }
        // If all cells are filled, return true
        if (!isEmpty) {  // if blank spaces exits then isEmpty is true, so we use !isEmpty is true then return true
            return true;
        }
        // Try values for the empty cell
        for (int value = 1; value <= 9; value++) {
            if (isValid(board, row, col, value)) {
                board[row][col] = value;
                if (solveSudoku(board)) {
                    return true;
                } else {
                    board[row][col] = 0; // backtrack
                }
            }
        }
        // No valid value found for the empty cell
        return false;
    }
    private static boolean isValid(int[][] board, int row, int col, int value) {
        int rowStart = (row / Grid_size) * Grid_size;
        int colStart = (col / Grid_size) * Grid_size;
        for (int i = 0; i < rows_and_columns; ++i) {
            //horizontal check 
            if (board[row][i] == value) {
                return false;
            }
            //vertical check
            if (board[i][col] == value) {
                return false;
            }
            // grid check 
            // int rowOffset = i % Grid_size;
            // int colOffset = i / Grid_size;
            // if (board[rowStart + rowOffset][colStart + colOffset] == value) {
            //     return false;
        }
        // Grid check with easy logic
        for (int i = rowStart; i < rowStart + Grid_size; i++) {
            for (int j = colStart; j < colStart + Grid_size; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][] board) {
        System.out.println("---------------SUDOKU SOLVER-------------");
        for (int row = 0; row < rows_and_columns; row++) {
            if (row % Grid_size == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < rows_and_columns; col++) {
                if (col % Grid_size == 0) {
                    System.out.print("| ");
                }
                int value = board[row][col];
                System.out.print(value == NO_VALUE ? " " : value);
                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
    public static void main(String[] args) {
        int[][] puzzle = {
            {0, 0, 0, 9, 0, 0, 3, 0, 7},
            {0, 0, 8, 3, 2, 0, 0, 0, 0},
            {0, 6, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 0, 5, 0, 8, 0, 6, 0, 0},
            {0, 4, 0, 0, 0, 0, 0, 0, 0},
            {9, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 8, 2, 0, 0},
            {4, 0, 7, 0, 0, 3, 0, 0, 0}
        };
        // Copy puzzle into board
        
        if (solveSudoku(puzzle)) {
            printBoard(puzzle);
        } else {
            System.out.println("Unable to solve the puzzle");
        }
    }
}