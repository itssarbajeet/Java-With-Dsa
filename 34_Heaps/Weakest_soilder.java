import java.util.*;
public class Weakest_soilder {
    static class Row implements Comparable<Row>{
        int soilders;
        int idx;
         public Row(int soilders,int idx){
            this.soilders=soilders;
            this.idx=idx;
            }
        @Override
        public int compareTo(Row r2){
            if(this.soilders==r2.soilders){
                return this.idx-r2.idx;
            }
            else{
                return this.soilders-r2.soilders;
            }       
        }
    }
    public static void main(String[] args) {
        int arr[][]={{1,0,0,0},
                     {1,1,1,1},
                     {1,0,0,0},
                     {1,0,0,0}};    
        int k=2;
        PriorityQueue<Row> pq= new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr[i].length;j++){
                count +=arr[i][j]  == 1?1:0;
            }
            pq.add(new Row(count,i));

    }
    for(int i=0;i<k;i++){
        System.out.println("R"+pq.remove().idx);
    }
    
}
}
