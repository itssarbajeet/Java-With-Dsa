import java.util.TreeSet;

public class TreeSetCode {
    public static void main(String[] args) {
        TreeSet<String> cities = new TreeSet<String>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");
        cities.add("Bangalore");
        cities.add("Noida");
        System.out.println(cities); //printed in soreted order
    }
}
