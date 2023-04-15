import java.util.*;
public class Indian_coins {
    public static void main(String args[]){
        Integer coins[]={2000,500,1,2,200,5,10,20,50,100};
        int amount=5900;
        Arrays.sort(coins, Comparator.reverseOrder());        int countOfCOins=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    countOfCOins++;
                    ans.add(coins[i]);
                    amount -=coins[i];
                }
            }
        }
        System.out.println("total (min) coins used = "+ countOfCOins);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i)+" ");
        }
        System.out.println();
    }
} 
