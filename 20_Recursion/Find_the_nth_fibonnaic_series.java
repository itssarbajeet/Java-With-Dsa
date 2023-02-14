import java.util.*;
public class Find_the_nth_fibonnaic_series {
    public static int Find_the_nth_fibonnaic_series1(int n){
        if (n==0 |n==1){
            return n;
        }
        else{
            int fn1=Find_the_nth_fibonnaic_series1(n-1);
            int fn2=Find_the_nth_fibonnaic_series1(n-2);
            int fn=fn1+fn2;
            return fn;
        }
        }
        public static  void main(String[] args) {
            int n=5;
            System.out.println(Find_the_nth_fibonnaic_series1(n));

    }

}
