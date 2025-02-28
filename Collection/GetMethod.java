package Collection;
import java.util.*;

public class GetMethod {
//The get(int index) method retrieves an element at the specified index.
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        
        System.out.println("Element at index 1: " + names.get(1));  // Bob


        //The get(Key key) method retrieves the value associated with a key.
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        System.out.println("Value for key 2: " + map.get(2));  // Banana
    }
}
