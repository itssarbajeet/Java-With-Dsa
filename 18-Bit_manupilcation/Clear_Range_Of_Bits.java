import java.util.*;
public class Clear_Range_Of_Bits {
    public static int clear_Range_Of_Bits1(int num, int i, int j) {
        int a = (~0 << (j + 1));
        int b = (1 << i) - 1;
        int c = a | b;
        return num & c;
    }
    public static void main(String[] args) {
        int num = 1023;
        int j = 6;
        
        int i = 2;
        System.out.println(clear_Range_Of_Bits1(num, i, j));
    }
}
