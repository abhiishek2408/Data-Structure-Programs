package DynamicProgramming.LinearDP;

/**
 * LeetCode 55: Jump Game
 * You are given an integer array nums. You are initially positioned at the
 * first index, and each element represents your maximum jump length at that position.
 * Return true if you can reach the last index.
 *
 * Approach 1: DP — dp[i] = can we reach index i?
 * Approach 2: Greedy — track the farthest reachable index
 */
public class _23_JumpGame {

    // DP approach
    public static boolean canJumpDP(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    // Greedy approach (optimal O(n))
    public static boolean canJumpGreedy(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can Jump (DP):     " + canJumpDP(nums1));     // true
        System.out.println("Can Jump (Greedy): " + canJumpGreedy(nums1)); // true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can Jump (DP):     " + canJumpDP(nums2));     // false
        System.out.println("Can Jump (Greedy): " + canJumpGreedy(nums2)); // false
    }
}
