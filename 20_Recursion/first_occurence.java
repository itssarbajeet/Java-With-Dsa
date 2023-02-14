import java.util.*;
public class first_occurence {
    public static int first_occurence19(int[] arr,int key,int i){
        if(arr[i]==key)
        {
            return i;
        }
        if(i==arr.length-1){
            return -1;
        }
        
        return first_occurence19(arr, key, i+1);

    }
    public static void main(String[] args) {    
        int[] arr = {1,2,3,4,5,7,9,10,2};
        int key=7;
        int i=0;
        System.out.println(first_occurence19(arr, key, i));
    
}
}

