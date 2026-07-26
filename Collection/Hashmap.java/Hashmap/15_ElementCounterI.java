import java.util.HashMap;
import java.util.Map;

public class ElementCounterI {
    public static void main(String[] args) {
        // Example array
        int[] array = {1, 2, 2, 3, 4, 4, 4, 5};

        // Create a HashMap to store the count of each element
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        // Iterate over the array
        for (int element : array) {
            // If the element is already in the map, increment its count
            if (elementCountMap.containsKey(element)) {
                elementCountMap.put(element, elementCountMap.get(element) + 1);
            } else {
                // If the element is not in the map, add it with a count of 1
                elementCountMap.put(element, 1);
            }
        }

        // Print the count of each element
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}