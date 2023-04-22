import java.util.*;
public class Implementaion_of_Priority_queue_ascending {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0); //O(log(n)) 
        pq.add(4);
        pq.add(3);
        pq.add(2);
        while(!pq.isEmpty()){
            System.out.println(pq.peek()); //O(1)
            pq.remove();//O(log n)
        }


    }
    
}
