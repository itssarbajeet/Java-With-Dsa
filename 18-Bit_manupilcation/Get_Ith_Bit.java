import java.util.*;
public class Get_Ith_Bit {
    public static int The_ith_Bit_is(int num, int i){
        if((num & 1<<i)== 0)
        {
            return 0;
        }
        else{
            return 1;
        }
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner (System.in);
        int i=obj.nextInt();
        int num=obj.nextInt();
        if(The_ith_Bit_is(num, i)==1)
        {
            System.out.print("The "+ i + "th Bit Of The " + num + "is 1"  );
        }
        else
        {
            System.out.print("The "+ i + "th Bit Of The " + num + "is 0"  );
        }

}
}

