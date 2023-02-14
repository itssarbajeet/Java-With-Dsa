import java.util.*;
public class Paring_Friends {
    public static int Paring_Friends1(int n){
        if(n==1 || n==2){
            return n;
        }
        int single=Paring_Friends1(n-1);
        int pairng=Paring_Friends1(n-2);
        int pairways= pairng*(n-1);
        return single + pairways;
        //or we can write in single line ( return Paring_Friends1(n-1)+(n-1)*Paring_Friends1(n-2);)
    }
    public static  void main(String[] args) {
        int n=5;
        System.out.print(Paring_Friends1(n));   
}
}