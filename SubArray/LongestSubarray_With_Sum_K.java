import java.util.HashMap;

class LongestSubarray_With_Sum_K {
    public static int longestSubarray(int[] nums, int K) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Stores (prefixSum, firstIndex)
        int sum = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // Compute prefix sum

            // ✅ Check if prefix sum itself is the target
            if (sum == K) {
                maxLength = i + 1;
            }

            // ✅ Check if a subarray with sum `K` exists
            if (map.containsKey(sum - K)) {
                maxLength = Math.max(maxLength, i - map.get(sum - K));
            }

            // ✅ Store the first occurrence of sum in the map
            // Store the first occurrence of the current prefix sum if not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {    //Output: 4  as (5, 2, 7, 1)
        int[] nums = {10, 5, 2, 7, 1, 9};
        int target = 15;
        System.out.println("Longest Subarray Length: " + longestSubarray(nums, target)); // Output: 4
    }
}

