package DynamicProgramming;

public class EqualPartition {
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


    // Optimized space complexity to O(target)
    public boolean canPartitionOptimized(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        EqualPartition solution = new EqualPartition();
        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartition(nums);
        System.out.println("Can the array be partitioned into two equal subsets? " + result);
        System.out.println("Can the array be partitioned into two equal subsets (optimized)? " + solution.canPartitionOptimized(nums));
    }
}
