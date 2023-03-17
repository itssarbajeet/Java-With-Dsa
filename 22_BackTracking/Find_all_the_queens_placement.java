import java.util.*;
class Find_all_the_queens_placement {
    public static  void printBoard(char[][] board){
        System.out.println("----- CHESS BOARD-----");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
    }}
    public  static void Find_all_the_queens_placement(char[][] board, int i) {
        if(i==board.length){
            printBoard(board);
            return;
        }
        for (int j=0;j<board.length;j++){
            board[i][j]='Q';
            Find_all_the_queens_placement(board, i+1);
            board[i][j]='.';
        }
    }
    
    public static void main(String[] args) {
        int n=2;
        char[][] board=new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j]='.';
            }}
            Find_all_the_queens_placement(board,0);
        }
    
    }
    