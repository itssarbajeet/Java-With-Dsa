import java.util.*;
public class Set_Ith_Bit {
    public static int Set_Ith_Bit1(int num, int i){
        return num | 1<<i;
    }
    public static void main(String[] args) {
        Scanner obj = new Scanner (System.in);
        int i=1;
        int num=obj.nextInt();
        System.out.print("the ith is now set as one and the new number is "+ Set_Ith_Bit1(num,i));

}
}
