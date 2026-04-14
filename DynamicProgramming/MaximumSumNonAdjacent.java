package DynamicProgramming;
//Problem: Maximum Sum of Non-Adjacent Elements
//Given an integer array nums, return the maximum sum of a subsequence such that no two elements 
// are adjacent in the original array.  maximum sum without picking adjacent elements from the array.
// The maximum sum of non-adjacent elements in the array can be found using dynamic programming. 
// The idea is to maintain an array dp where dp[i] represents the maximum sum of non-adjacent elements 
// from the first i elements of the input array. The recurrence relation can be defined as follows:

public class MaximumSumNonAdjacent {
    
    class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }
}

    // Space Optimized approach to solve the Maximum Sum of Non-Adjacent Elements problem
    class SolutionSpaceOptimized {
        public int maxSum(int[] nums) {
            int n = nums.length;

            if (n == 1) return nums[0];

            int prev2 = nums[0]; // dp[i-2]
            int prev1 = Math.max(nums[0], nums[1]); // dp[i-1]

            for (int i = 2; i < n; i++) {
                int curr = Math.max(prev1, prev2 + nums[i]);
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1;
        }
    }

    public static void main(String[] args) {
        MaximumSumNonAdjacent maxSumNonAdjacent = new MaximumSumNonAdjacent();
        int[] nums = {3, 2, 7, 10};
        Solution solution = maxSumNonAdjacent.new Solution();
        int result = solution.maxSum(nums);
        System.out.println("Maximum sum of non-adjacent elements: " + result);
    }


}
