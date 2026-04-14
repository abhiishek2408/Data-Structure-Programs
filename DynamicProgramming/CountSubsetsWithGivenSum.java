package DynamicProgramming;

public class CountSubsetsWithGivenSum {
    
    public int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}

