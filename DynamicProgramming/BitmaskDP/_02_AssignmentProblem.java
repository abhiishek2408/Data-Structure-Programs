package DynamicProgramming.BitmaskDP;
public class _02_AssignmentProblem {
    public int minCost(int[][] cost) {
        int n = cost.length;
        int[] dp = new int[1 << n];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int x = Integer.bitCount(mask);
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) {
                    dp[mask | (1 << j)] = Math.min(dp[mask | (1 << j)], dp[mask] + cost[x][j]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}