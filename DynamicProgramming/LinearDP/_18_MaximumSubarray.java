package DynamicProgramming.LinearDP;

/**
 * LeetCode 53: Maximum Subarray
 * Given an integer array nums, find the subarray with the largest sum and return its sum.
 * Implementation using Dynamic Programming (Kadane's variation).
 */
public class _18_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < n; i++) {
            // dp[i] represents the maximum subarray sum ending at index i
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums)); // Output: 6
    }
}
