import java.util.*;

public class Fast_exponential {
    public static int Fast_exponential1(int a,int n)
    {
        int ans=1;
        while(n>0){
            if((n&1)==1){
                ans=ans*a; }
            a=a*a;
            n=n>>1;}
        return ans;
    }
    public static void main(String[] args) {
        int a=5;
        int n=3;
        System.out.println(a +" to the power " + n + " is " + Fast_exponential1(a,n));
    }
    
}
