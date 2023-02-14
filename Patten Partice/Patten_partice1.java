import java.util.*;
class Patten_partice1{
    public static int patten2(int n){
        for(int i=n;i>0;i--){
            for (int j=0;j<i;j++){
                System.out.print("*");
            }
            int f=(n*2-(i)*2);
            for (int k=0;k<f;k++)
            {
                System.out.print(" ");
                
            }
            for (int j=0;j<i;j++){
                System.out.print("*");
            }
            
            System.out.println();
        }
        return 0;
    }
    public static int patten1(int n){
        for(int i=0;i<n;i++){
            for (int j=1;j<=i+1;j++){
                System.out.print("*");
            }
            int f=(n*2-(i+1)*2);
            for (int k=0;k<=f-1;k++)
            {
                System.out.print(" ");
            }
            for (int j=1;j<=i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int Input=myObj.nextInt();
        patten1(Input);
        patten2(Input);
    }
}
