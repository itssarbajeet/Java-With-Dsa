import java.util.*;
public class next_Greatest_Element {
    public static void main(String args[]){
    int arr[]={6,8,0,1,3};
    Stack <Integer> s=new Stack<>();
    int nextGreater[]=new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
        //step 1 While loop
        while(!s.empty() && arr[s.peek()]<=arr[i]){
            s.pop();
        }
        //step 2 assign value using condition to the next greater
        if(s.empty()){
            nextGreater[i]= -1;
        }
        else{
            nextGreater[i]= arr[s.peek()];
        }
        //step 3 push it
        s.push(i);
    }
    for(int j=0;j<nextGreater.length;j++){
        System.out.print(nextGreater[j]+" ");
    }
}}
 