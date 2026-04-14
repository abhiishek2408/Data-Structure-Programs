package DynamicProgramming;
// LeetCode 740. Delete and Earn
// Given an array nums of integers, you can perform operations on the array.
// In each operation, you pick any nums[i] and delete it to earn nums[i] points. 
// After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
// You start with 0 points. Return the maximum points you can earn by applying such operations.
// Isko convert karo into House Robber problem

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[maxVal + 1];
        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);

        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }

        return dp[maxVal];
    }
    

    public int deleteAndEarnOptimized(int[] nums) {
        int max = 0;

        // find max value
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        // build points array
        for (int num : nums) {
            points[num] += num;
        }

        // house robber logic
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i <= max; i++) {
            int curr = Math.max(prev1, prev2 + points[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();
        int[] nums = {3, 4, 2};
        int result = solution.deleteAndEarn(nums);
        System.out.println("Maximum points earned: " + result); // Output: 6
    }

}
