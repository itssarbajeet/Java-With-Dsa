import java.util.*;
public class hashMap_Operations {
    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        
        // Add some data
        myMap.put("Alice", 25);
        myMap.put("Bob", 30);
        myMap.put("Charlie", 35);
        myMap.put("David", 40);
    
        // Retrieve some data
        int age1 = myMap.get("Alice");
        int age2 = myMap.get("Charlie");
        System.out.println("Alice's age is " + age1);
        System.out.println("Charlie's age is " + age2);
    
        // Check if keys exist
        boolean aliceExists = myMap.containsKey("Alice");
        boolean eveExists = myMap.containsKey("Eve");
        System.out.println("Alice exists: " + aliceExists);
        System.out.println("Eve exists: " + eveExists);
    
        // Remove some data
        myMap.remove("David");
    
        // Check size of map
        int size = myMap.size();
        System.out.println("Size of map: " + size);
    
        // Check if map is empty
        boolean isEmpty = myMap.isEmpty();
        System.out.println("Map is empty: " + isEmpty);
    
        // Clear the map
        myMap.clear();
    
        // Check size of map after clearing
        int sizeAfterClear = myMap.size();
        System.out.println("Size of map after clearing: " + sizeAfterClear);
    }
    
    
}
