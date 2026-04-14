package DynamicProgramming;
//Problem: Climbing Stairs II
//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1, 2, or 3 steps. Each step has a cost associated with it, 
// given in an array costs where costs[i] is the cost of step i. You need to find the minimum cost to reach the top of the staircase.
// the cost of jumping from step i to step i + k (where k is 1, 2, or 3) is costs[i] + k^2.
//Find the minimum cost to reach the top of the staircase.

public class ClimbingStairII {

    public int minCostClimbingStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        dp[0] = 0; // start point

        for (int i = 1; i <= n; i++) {
            int cost = costs[i - 1]; // because array 0-indexed hai

            // 1 step jump
            dp[i] = dp[i - 1] + cost + 1;

            // 2 step jump
            if (i >= 2) {
                dp[i] = Math.min(dp[i], dp[i - 2] + cost + 4);
            }

            // 3 step jump
            if (i >= 3) {
                dp[i] = Math.min(dp[i], dp[i - 3] + cost + 9);
            }
        }

        return dp[n];
    }

}
