import java.util.*;
public class LinkedHashset {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<String>();
        cities.add("Delhi");
        cities.add("Delhi"); 
        cities.add("Mumbai");
        cities.add("Chennai");
        cities.add("Bangalore");
        cities.add("Noida");
        System.out.println(cities);
    }
    
}
