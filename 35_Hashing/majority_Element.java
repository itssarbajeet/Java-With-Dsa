import java.util.*;

public class majority_Element {
  public static void main(String[] args) {
    int[] arr = {1, 3,2,5,1,3,1,5,1};
    HashMap<Integer, Integer> freqMap = new HashMap<>();

    // Count the frequency of each element in the array
    for (int num : arr) {
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
 
    // Print all elements that appear more than n/3 times
    for (Integer key : freqMap.keySet()) {
      if (freqMap.get(key) > arr.length / 3) {
        System.out.println(key);
      }
    }
  }
} 
