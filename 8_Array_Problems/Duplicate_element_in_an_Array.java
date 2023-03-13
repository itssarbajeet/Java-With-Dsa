import java.util.*;
class Main {

    public static boolean containsDuplicate(int[] nums) {
        boolean a=false;
        for (int i=0;i<=nums.length-2;i++){
            if(nums[i]==nums[i+1]){
                a=true ;
            }       
}
        return a;
    }
public static void main(String[] args) {
int arr[]={1,2,3,1};
System.out.println(containsDuplicate(arr));
}
}
