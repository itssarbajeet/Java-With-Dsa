import java.util.*;
public class Stock_span_problem{
    public static void stockSpan(int Stock[],int span[]){
        Stack <Integer>s=new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1;i< Stock.length;i++){
            int currPrice=Stock[i];
            while(!s.isEmpty() && currPrice>Stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }
            else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;

            }
            s.push(i);
        }

    }
    public static void main(String args[]){
        int Stock[]={100,80,60,80,70,60,85,100};
        int span[]=new int[Stock.length];
        stockSpan(Stock,span);
        for(int i=0;i<span.length;i++){
            System.out.println(span[i]+" ");
        }


    }
}