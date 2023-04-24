import java.util.*;

public class Iterate_over_HashMap {
   public static void main(String[] args) {
      // Creating a HashMap
      HashMap<String, Integer> map = new HashMap<>();
      
      // Adding key-value pairs to the HashMap
      map.put("Alice", 25);
      map.put("Bob", 30);
      map.put("Charlie", 35);
      
      // Retrieving the set of keys from the HashMap
      Set<String> keySet = map.keySet();
      
      // Iterating over the key set using a for-each loop
      for (String key : keySet) {
         System.out.println(key + " => " + map.get(key));
      }
   }
}
