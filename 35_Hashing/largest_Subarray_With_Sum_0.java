import java.util.*;
public class largest_Subarray_With_Sum_0 {
    public static void main(String args[]){
        int arr[]={15,-2,2,-8,1,7,10,23};

        HashMap<Integer,Integer> map=new HashMap<>();
        //(sum,idx)
        int sum=0;
        int len=0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum)){
                len=Math.max(len,j-map.get(sum)); //len,(j-i)
    
            }
            else{
                map.put(sum,j);
            }
        }
        System.out.print("largest subarray with sum as 0 -> "+len);
    }


    
}
