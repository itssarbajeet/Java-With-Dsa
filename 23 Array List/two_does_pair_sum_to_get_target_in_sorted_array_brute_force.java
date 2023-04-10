import java.util.*;
public class two_does_pair_sum_to_get_target_in_sorted_array_brute_force {
    public static boolean Calculate_most_sumPair_stored(ArrayList<Integer> sumPair,int target)
    {
        for(int i=0;i<sumPair.size();i++){
            for(int j=i+1;j<sumPair.size();j++){
                if(sumPair.get(i)+sumPair.get(j)==target){
                    return true;
                }
                
    }
}
return false;
    }
    public static void main(String[] args) {
    ArrayList<Integer> sumPair=new ArrayList<>();
    sumPair.add(1);
    sumPair.add(2);
    sumPair.add(3);
    sumPair.add(4);
    sumPair.add(5);
    int target=5;
    System.out.println(Calculate_most_sumPair_stored(sumPair,target));
    }
    }

