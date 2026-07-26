package DynamicProgramming.GameTheoryDP;
public class _04_OptimalStrategyForAGame {
    public long maximumAmount(int arr[], int n) {
        long[][] dp = new long[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) dp[i][j] = arr[i];
                else if (gap == 1) dp[i][j] = Math.max(arr[i], arr[j]);
                else {
                    long val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    long val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        return dp[0][n - 1];
    }
}