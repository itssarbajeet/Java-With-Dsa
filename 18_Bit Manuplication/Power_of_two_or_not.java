import java.util.*;
public class Power_of_two_or_not {
    public static void main(String[] args) {
        int s=0;
        int d=0;
        int n=512;
        for(int i=0;i<31;i++){
            ++s;
            if(1<<i== n){
                
                System.out.println(n+" is power of two");
            }
            else
            
            { 
                ++d;
            }
        }
        if(s==d){
            System.out.print(n +" is not a Power of 2");
        }
            
        }}

    

