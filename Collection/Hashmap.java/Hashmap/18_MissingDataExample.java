import java.util.HashMap;
import java.util.Map;

public class MissingDataExample {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);

        // Retrieve scores with default
        int aliceScore = scores.getOrDefault("Alice", 0);
        int charlieScore = scores.getOrDefault("Charlie", 0);

        System.out.println("Alice's score: " + aliceScore); // Output: Alice's score: 85
        System.out.println("Charlie's score: " + charlieScore); // Output: Charlie's score: 0
        
    }
}