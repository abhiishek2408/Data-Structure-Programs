package DynamicProgramming;
//Problem: House Robber
//You are a professional robber planning to rob houses along a street. Each house has a certain 
// amount of money stashed, the only constraint stopping you from robbing each of them is that 
// adjacent houses have security systems connected and it will automatically contact the police 
// if two adjacent houses were broken into on the same night.
//Given an integer array nums representing the amount of money of each house, return the maximum amount 
// of money you can rob tonight without alerting the police.

public class HouseRobber {
    
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    public int robOptimized(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        int result = houseRobber.rob(nums);
        System.out.println("Maximum amount of money the robber can steal: " + result);
    }
}
