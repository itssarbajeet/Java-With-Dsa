// there is a tiling to be done in a house let the width of room be 2 and length be n so the 
// area will be 2*n and let the tile dimension would be 2*1
import java.util.*;
public class Tiling_problem {
    public static int Tiling_problem1(int num){
        if(num==0 ||num==1 ){
            return 1;
        }
        int Vertical=Tiling_problem1(num-1);
        int Horizontal=Tiling_problem1(num-2);
        return Vertical+Horizontal;
    }
    public static  void main(String[] args) {
        System.out.println(Tiling_problem1(5));}
}

