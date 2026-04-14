package DynamicProgramming;
// 0-1 Knapsack problem
// Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
// Time complexity: O(n*W) where n is the number of items and W is the capacity of the knapsack
// Space complexity: O(n*W) for the 2D dp array and O(W) for the optimized space complexity version
//

public class Knapsack01 {

    public int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i-1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i-1][w],
                        val[i-1] + dp[i-1][w - wt[i-1]]
                    );
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        return dp[n][W];
    }


    public int knapsackOptimized(int[] wt, int[] val, int W) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < wt.length; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }
}
