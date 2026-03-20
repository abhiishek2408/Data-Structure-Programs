import java.util.HashMap;
import java.util.Map;

public class NonRepeatingElement {
    
    public int findNonRepeating(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    public int firstNonRepeating(int[] arr) {
    Map<Integer, Integer> freq = new HashMap<>();

    // Count frequencies
    for(int num : arr) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Find first non-repeating
    for(int num : arr) {
        if(freq.get(num) == 1) return num;
    }

    return -1; // if none
}

    public static void main(String[] args) {
        NonRepeatingElement solution = new NonRepeatingElement();
        int[] nums = {2, 3, 5, 4, 5, 3, 4};
        System.out.println(solution.findNonRepeating(nums)); // Output: 2
        System.out.println(solution.firstNonRepeating(nums)); // Output: 2
    }
}
