import java.util.*;
public class one_does_pair_sum_to_get_target_in_sorted_array_optimized {
    public static boolean Calculate_most_sumPair_stored(ArrayList<Integer> sumPair,int target)
    {
        int Lindex=0, Rindex=sumPair.size()-1;
        while(Lindex!=Rindex){
            if(sumPair.get(Lindex)+sumPair.get(Rindex)== target){
                return true;
            }
            else if(sumPair.get(Lindex)+sumPair.get(Rindex)<target)
            {
                Lindex++;
            }
            else if(sumPair.get(Lindex)+sumPair.get(Rindex)>target)
                Rindex--;
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

