package ETPquestion;

import java.util.HashMap;

public class SubarrayCounter {
    public int numberOfSubarrays(int[] nums, int k) {
        // HashMap to store the frequency of prefix odd count
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1); // Base case: 0 odd numbers before starting

        int oddCount = 0;  // Keeps track of the current number of odd numbers
        int result = 0;

        for (int num : nums) {
            // If the number is odd, increment the odd count
            if (num % 2 == 1) {
                oddCount++;
            }

            // If there is a previous prefix with (oddCount - k), it means
            // there is a subarray with exactly 'k' odd numbers
            if (prefixCounts.containsKey(oddCount - k)) {
                result += prefixCounts.get(oddCount - k);
            }

            // Update the frequency of the current odd count
            prefixCounts.put(oddCount, prefixCounts.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        SubarrayCounter solution = new SubarrayCounter();

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        System.out.println(solution.numberOfSubarrays(nums, k));  // Output: 2
    }
}

