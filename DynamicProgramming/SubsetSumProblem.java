package DynamicProgramming;

public class SubsetSumProblem {
    public boolean subsetSum(int[] nums, int target) {
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
    public boolean subsetSumOptimized(int[] nums, int target) {
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
        SubsetSumProblem solution = new SubsetSumProblem();
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        boolean result = solution.subsetSum(nums, target);
        System.out.println("Is there a subset with sum " + target + "? " + result);
    }
}


// dry run optimized space complexity method with 
// nums = {3, 34, 4, 12, 5, 2} and target = 9  line by line
// Initial dp array: [true, false, false, false, false, false, false, false, false, false] 
// as dp[0] is true because we can always make sum 0 with an empty subset
// After processing num = 3: dp array becomes [true, false, false, true, false, false, false, false, false, false] as we can make sum 3 by including the number 3 with the empty subset

