import java .util.*;
public class Check_sorted_array_or_not {
    public static boolean Check_sorted_array1(int i, int arr[]){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return Check_sorted_array1(i+1, arr);
    }

    public static  void main(String[] args) {
        int i =0;
        int arr[]={1,2,3,4,50,6};
        System.out.print(Check_sorted_array1(i, arr));
    }
}