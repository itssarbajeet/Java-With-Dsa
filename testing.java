import java.util.*;

public class testing {
    public static void main(String[] args) {
        int sar=12345;
        int sum=0;
        while(sar!=0){
            int c=sar%10;
             sum=sum*10+c;
            sar/=10;
        }
        System.out.println(sum);
}}
