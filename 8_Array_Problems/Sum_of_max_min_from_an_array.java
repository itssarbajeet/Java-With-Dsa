import java.util.*;
class DSA_Question {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of ELEMENTS IN THE ARRAY") ;
        int n = sc.nextInt();
        int a[] = new int[n];   
        for(int i=0;i<n;i++){
             a[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        System.out.println("THE SUM OF MIN AND MAX IS : "+ob.findSum(a,n));
	}
}
class Solution
{ 
    public static int findSum(int A[],int N) 
    {
       int m= A[0];
       int max= Integer.MIN_VALUE;
       int min= Integer.MAX_VALUE;
       for(int i=0;i<A.length;i++){
           if(max<A[i]){
               max=A[i];
           }
           if(min>A[i]){
               min=A[i];
           }
       }
       return max+min;
    }
}
