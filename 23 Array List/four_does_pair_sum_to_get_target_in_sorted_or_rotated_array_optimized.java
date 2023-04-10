import java.util.*;

import javax.swing.text.AbstractDocument.LeafElement;
public class four_does_pair_sum_to_get_target_in_sorted_or_rotated_array_optimized {
    public static boolean Calculate_most_sumPair_stored(ArrayList<Integer> sumPair,int target)
    {
        int Lindex=0, Rindex=sumPair.size()-1,n=sumPair.size();
        for(int i=0;i<sumPair.size()-1;i++){
            if(sumPair.get(i)>sumPair.get(i+1)){
                Lindex=i+1;
                Rindex=i;
                break;
            }
        }
        while(Lindex!=Rindex){
            if(sumPair.get(Lindex)+sumPair.get(Rindex)== target){
                return true;
            }
            else if(sumPair.get(Lindex)+sumPair.get(Rindex)<target)
            {
                Lindex=(Lindex+1)%n;
            }
            else if(sumPair.get(Lindex)+sumPair.get(Rindex)>target)
                Rindex=(Rindex+n-1)%n;
            }
        
        return false;
    }
    
    public static void main(String[] args) {
    ArrayList<Integer> sumPair=new ArrayList<>();
    sumPair.add(10);
    sumPair.add(11);
    sumPair.add(1);
    sumPair.add(2);
    sumPair.add(3);
    sumPair.add(4);
    sumPair.add(5);
    int target=5;
    System.out.println(Calculate_most_sumPair_stored(sumPair,target));
    }
    }
