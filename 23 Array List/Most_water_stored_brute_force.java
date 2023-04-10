import java.util.*;
class Most_water_stored_brute_force {
public static int Calculate_most_water_stored(ArrayList<Integer> water)
{
    int maxWater=0;
    for(int i=0;i<water.size();i++){
        for(int j=i+1;j<water.size();j++){
            int height=Math.min(water.get(i),water.get(j));
            int width =j-i;
            int currWater=height*width;
            maxWater=Math.max(currWater,maxWater);
        }
    }
    return maxWater;
}
public static void main(String[] args) {
ArrayList<Integer> water=new ArrayList<>();
water.add(1);
water.add(8);
water.add(6);
water.add(2);
water.add(5);
water.add(4);
water.add(8);
water.add(3);
water.add(7);


System.out.println(Calculate_most_water_stored(water));
}
}