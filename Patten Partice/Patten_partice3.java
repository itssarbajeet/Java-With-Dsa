import java.util.*;

class Main {
    public static void main(String[] args) {
        for(int i=4;i>0;i--){
            for(int j=i-1;j>0;j--){
                System.out.print(" ");
            }
            for(int k=4;k>=i;k--){
                System.out.print("* ");
            }
            System.out.println("\n");
        }
    }
    }
