package DynamicProgramming.BitmaskDP;
public class _03_PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] dp = new int[1 << nums.length];
        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            if (dp[mask] == -1) continue;
            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) == 0 && dp[mask] + nums[i] <= target) {
                    dp[mask | (1 << i)] = (dp[mask] + nums[i]) % target;
                }
            }
        }
        return dp[(1 << nums.length) - 1] == 0;
    }
}