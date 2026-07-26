package DynamicProgramming.GameTheoryDP;
public class _02_StoneGameII {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) suffixSum[i] = suffixSum[i + 1] + piles[i];
        return dfs(piles, dp, suffixSum, 0, 1);
    }
    private int dfs(int[] piles, int[][] dp, int[] suffixSum, int i, int M) {
        if (i == piles.length) return 0;
        if (i + 2 * M >= piles.length) return suffixSum[i];
        if (dp[i][M] != 0) return dp[i][M];
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            res = Math.max(res, suffixSum[i] - dfs(piles, dp, suffixSum, i + x, Math.max(M, x)));
        }
        return dp[i][M] = res;
    }
}