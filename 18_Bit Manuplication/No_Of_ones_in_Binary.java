import java.util.*;
public class No_Of_ones_in_Binary {
    public static void main(String[] args) {
        int n=1023;
        int c=0;
        int e=n;
        while (n>0) {          
            if ((n & 1)==1)
            {
                
                c=c+1;
            }
            n=n>>1;
        }
        System.out.print("the no of 1 in"+ e +"is "+c);
}
}

