import java.util.*;
public class Min_Absolute_difference_pairs {
    public static void main(String args[]){
    int A[]={4,1,8,7};
    int B[]={2,3,6,5};
    Arrays.sort(A);
    Arrays.sort(B);
    int minDif=0;
    for(int i=0;i<A.length;i++){
        minDif+=Math.abs(A[i]-B[i]);
    }
    System.out.println("min absolute diff of pairs = "+minDif );
      }    
}
 