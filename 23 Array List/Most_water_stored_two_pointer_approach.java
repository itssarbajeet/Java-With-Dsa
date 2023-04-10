import java.util.*;
public class Most_water_stored_two_pointer_approach {
    public static int Calculate_most_water_stored(ArrayList<Integer> water)
{
    int Lindex=0,Rindex=water.size()-1,maxwater=0;
    while(Lindex<Rindex){
        int height= Math.min(water.get(Lindex),water.get(Rindex));
        int width=Rindex-Lindex;
        int currWater=height*width;
        maxwater=Math.max(maxwater, currWater);
        if(water.get(Lindex)<water.get(Rindex)){
            Lindex++;
        }
        else{
            Rindex--;
        }
        
    }
    return maxwater;
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