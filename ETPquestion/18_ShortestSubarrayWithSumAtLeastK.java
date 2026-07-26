package ETPquestion;

import java.util.*;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        // Step 1: Compute prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 2: Use a deque to maintain indices
        Deque<Integer> deque = new ArrayDeque<>();
        int minLen = n + 1;

        for (int i = 0; i <= n; i++) {
            // Check for valid subarray sum
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - deque.pollFirst());
            }

            // Maintain increasing order in deque
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return (minLen <= n) ? minLen : -1;
    }

    // Test cases
    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK sol = new ShortestSubarrayWithSumAtLeastK();
        System.out.println(sol.shortestSubarray(new int[]{1}, 1));        // Output: 1
        System.out.println(sol.shortestSubarray(new int[]{1, 2}, 4));     // Output: -1
        System.out.println(sol.shortestSubarray(new int[]{2, -1, 2}, 3)); // Output: 3
    }
}

