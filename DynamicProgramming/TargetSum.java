package DynamicProgramming;
// Target Sum problem
// Given an array of integers and a target sum, find the number of ways to assign symbols to make the sum of the integers equal to the target sum.
// Time complexity: O(n*target) where n is the number of elements in the array and target is the target sum
// Space complexity: O(target) for the dp array

public class TargetSum {
    
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // If total sum is less than target or (total sum - target) is odd, we cannot partition it into two subsets
        if (totalSum < target || (totalSum - target) % 2 != 0) {
            return 0;
        }
        int subsetSum = (totalSum - target) / 2;
        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
}

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution.findTargetSumWays(nums, target);
        System.out.println("Number of ways to assign symbols to make sum " + target + ": " + result);
    }

}