import java.util.Scanner;
public class sumofDiagonal {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the size of the matrix");
        int n=ob.nextInt();
        int arr[][]=new int[n][n];
        System.out.println("Enter the elements of the matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=ob.nextInt();
            }
        }
         
        int sum = 0;
        int index=2;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i][i];
            if(i==index){
                index--;
                continue;
            }
            sum+=arr[i][index];
            index--;
        }
        System.out.println(sum);
    }
}
