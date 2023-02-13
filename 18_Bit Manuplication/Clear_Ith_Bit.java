import java.util.*;
public class Clear_Ith_Bit {
    public static int Clear_Ith_Bit1 (int num,int i) {
        int r= ~(1<<i);
        return num & r;
    
    }
    public static void main(String [] args ){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number");
        int num=sc.nextInt();
        System.out.println("enter the ith position to clear");
        int i=sc.nextInt();
        
        System.out.println("The "+ i + "th Bit Of The " + num + "is Cleared and The new num is "+ Clear_Ith_Bit1(num, i));
    }
    
}
