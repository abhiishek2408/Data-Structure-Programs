package DynamicProgramming;

public class HouseRobberII {

// Dynamic Programming approach to solve the House Robber II problem

    public int robDP(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Case 1: Rob houses from index 0 to n-2
        int maxRob1 = robLinear(nums, 0, nums.length - 2);

        // Case 2: Rob houses from index 1 to n-1
        int maxRob2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(maxRob1, maxRob2);
    }


    public int robLinearDP(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 0) return 0;
        if (n == 1) return nums[start];

        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }

        return dp[n - 1];
    }



    // Optimized approach to solve the House Robber II problem
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Case 1: Rob houses from index 0 to n-2
        int maxRob1 = robLinear(nums, 0, nums.length - 2);

        // Case 2: Rob houses from index 1 to n-1
        int maxRob2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(maxRob1, maxRob2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
