package Recursion;

import java.util.*;

class CountSubsetsSumMemo {
    public static int countSubsets(int[] nums, int n, int sum, int[][] dp) {
        if (sum == 0) return 1;
        if (n == 0) return 0;

        if (dp[n][sum] != -1) return dp[n][sum];

        if (nums[n - 1] > sum)
            return dp[n][sum] = countSubsets(nums, n - 1, sum, dp);

        return dp[n][sum] = countSubsets(nums, n - 1, sum, dp) + countSubsets(nums, n - 1, sum - nums[n - 1], dp);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 8, 10};
        int target = 10;
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println("Total subsets with sum " + target + ": " + countSubsets(nums, nums.length, target, dp));
    }
}
