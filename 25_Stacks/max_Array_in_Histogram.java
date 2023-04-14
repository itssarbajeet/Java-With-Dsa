import java.util.*;
public class max_Array_in_Histogram {
    public static void find_max_area_of_Histogram(int[]arr){
    int maxArea=Integer.MIN_VALUE;
    Stack <Integer> s=new Stack<>();
    int nsl[]=new int[arr.length];
    int nsr[]=new int[arr.length];
    // next smaller element
    for(int i=arr.length-1;i>=0;i--){
        //step 1 While loop
        while(!s.empty() && arr[s.peek()]>=arr[i]){
            s.pop();
        }
        //step 2 assign value using condition to the next smaller
        if(s.empty()){
            nsr[i]= arr.length;
        }
        else{
            nsr[i]= s.peek();
        }
        //step 3 push it
        s.push(i);
    }
    s=new Stack<>();
    //previous smaller element
    for(int i=0;i<arr.length;i++){
        //step 1 While loop
        while(!s.empty() && arr[s.peek()]>=arr[i]){
            s.pop();
        }
        //step 2 assign value using condition to the previous smaller
        if(s.empty()){
            nsl[i]= -1;
        }
        else{
            nsl[i]= s.peek();
        }
        //step 3 push it
        s.push(i);
    }
    //find the area
    for(int i=0;i<arr.length;i++){
        int height=arr[i];
        int width=nsr[i]-nsl[i]-1;
        int currArea=height*width;
        maxArea=Math.max(currArea,maxArea);
    }
    System.out.println("The max area of the histogram :"+ maxArea);
}
public static void main(String args[]){
    int arr[]={2,4,6,2};
    find_max_area_of_Histogram(arr);
}}
 
    

