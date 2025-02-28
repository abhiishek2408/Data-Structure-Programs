import java.util.HashMap;
import java.util.Map;

public class ElementCounterII {
    public static void main(String[] args) {
        // Example array
        int[] array = {1, 2, 2, 3, 4, 4, 4, 5};

        // Create a HashMap to store the count of each element
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        // Iterate over the array
        for (int element : array) {
            // Use getOrDefault to get the current count or 0 if the element is not present
            int count = elementCountMap.getOrDefault(element, 0);
            // Update the count in the map
            elementCountMap.put(element, count + 1);
        }

        // Print the count of each element
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
}