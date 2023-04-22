import java.util.*;
public class implementation_of_heap_functions {
    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){
            //add at last idx
            arr.add(data);
            int x=arr.size()-1; //x is child index
            int par=(x-1)/2;//parent index

            while(arr.get(x)<arr.get(par)){
                //swap
                int temp=arr.get(x);// get is used to get the value in that index
                arr.set(x,arr.get(par));  //set is used to assign the value in that index
                arr.set(par, temp);
            }
            x= par;
            par=(x-1)/2;

        }
        public int peek(){
            return arr.get(0);

        }
        private void heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i; 

            if(left<arr.size() && arr.get(left)<arr.get(minIdx)){
                minIdx=left;
            }

            if(right<arr.size() && arr.get(right)<arr.get(minIdx)){
                minIdx=right;
            }
            
            if(minIdx!=i){
                //swap
                int temp=arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }

        }
        public int remove(){
            int data=arr.get(0);
            //step 1- swap first and last
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);

            //step 2- remove last 
            arr.remove(arr.size()-1);

            //step 3 -heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }


         

    }
    public static void main(String args[]){
        Heap h=new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove(); 
        }
        

    }
}
