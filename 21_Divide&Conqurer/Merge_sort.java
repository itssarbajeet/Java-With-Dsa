import java.util.*;
public class Merge_sort {
    public static void PrintArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    } 
    public static void Merge_sort(int[] arr, int si, int ei, int mid){
        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= ei){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= ei){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(int l = 0; l < temp.length; l++){
            arr[si+l] = temp[l];
        }
    }
    public static void Merge_sort1(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = (si+ei)/2;
        Merge_sort1(arr, si, mid);
        Merge_sort1(arr, mid+1, ei); 
        Merge_sort(arr, si, ei, mid);        }  
    public static void main(String[] args) {
        int[] arr = {1,-2,8,4,5,7};
        int si = 0;
        int ei = arr.length-1;
        Merge_sort1(arr, si, ei);
        PrintArr(arr);
    }
}

