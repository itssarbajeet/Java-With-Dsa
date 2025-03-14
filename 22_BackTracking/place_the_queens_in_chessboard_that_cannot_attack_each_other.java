class PlaceQueensOnChessboard {
    public static boolean isSafe(char[][] board, int i, int j) {
        // Check if there's any queen in the same column
        for (int row = 0; row < i; row++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        //Check upper-left diagonal
        for (int row = i - 1, column = j - 1; row >= 0 && column >= 0; row--, column--) {
            if (board[row][column] == 'Q') {
                return false;
            }
        }
        // Check upper-right diagonal
        for (int row = i - 1, column = j + 1; row >= 0 && column < board.length; row--, column++) {
            if (board[row][column] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char[][] board) {
        System.out.println("------------- CHESS BOARD----------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void  placeQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                placeQueens(board, row + 1);
                board[row][j] = '.';
            }
        }
    } 
    public static void main(String[] args) {
        
        int n = 4;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        placeQueens(board, 0);
    }
}
