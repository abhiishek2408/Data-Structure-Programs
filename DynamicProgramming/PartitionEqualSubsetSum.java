package DynamicProgramming;
// Partition Equal Subset Sum problem
// Given an array of integers, determine if it can be partitioned into two subsets such that the sum of elements in both subsets is the same.
// Time complexity: O(n*target) where n is the number of elements in the array and target is the total sum of the array divided by 2
// Space complexity: O(n*target) for the 2D dp array and O(target) for the optimized space complexity version

public class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // If total sum is odd, we cannot partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;
        return subsetSum(nums, target);
    }

    private boolean subsetSum(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target];
    }
}
