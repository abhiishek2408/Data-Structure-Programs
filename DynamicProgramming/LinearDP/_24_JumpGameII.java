package DynamicProgramming.LinearDP;

/**
 * LeetCode 45: Jump Game II
 * Given an array of non-negative integers nums, you are initially positioned
 * at the first index. Each element represents your max jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Approach 1: DP — dp[i] = minimum jumps to reach index i
 * Approach 2: Greedy BFS — O(n)
 */
public class _24_JumpGameII {

    // DP approach O(n^2)
    public static int jumpDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    // Greedy approach O(n)
    public static int jumpGreedy(int[] nums) {
        int jumps = 0, farthest = 0, currentEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Min Jumps (DP):     " + jumpDP(nums));     // Output: 2
        System.out.println("Min Jumps (Greedy): " + jumpGreedy(nums)); // Output: 2

        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Min Jumps (DP):     " + jumpDP(nums2));     // Output: 2
        System.out.println("Min Jumps (Greedy): " + jumpGreedy(nums2)); // Output: 2
    }
}
