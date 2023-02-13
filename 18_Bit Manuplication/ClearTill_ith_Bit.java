import java .util.*;
public class ClearTill_ith_Bit {
    public static int Clear_Till_Ith_Bit(int num,int i){
        return num &(~0<<i);

    }
    public static  void main(String[] args) {
        int num=15;
        int i=2;
        System.out.print(Clear_Till_Ith_Bit(num, i));
}
}
