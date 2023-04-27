import java.util.*;
public class using_hashSet_Iterator_function {
    public static void main(String[] args) {
        HashSet<String> cities =new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");
        cities.add("Bangalore");
        cities.add("Noida");
        Iterator it=cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            }
            }


    }

    
 