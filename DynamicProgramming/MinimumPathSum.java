package DynamicProgramming;
// LeetCode 64. Minimum Path Sum
// Given a m x n grid filled with non-negative numbers, find a path from top left to 
// bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.
// Each cell represents the minimum path sum to reach that cell. So, for each cell, 
// we can reach it from the top cell or from the left cell. Hence, 
// dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]

public class MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // rest cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }


    // Optimized space complexity to O(n)
    public int minPathSumOptimized(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[j] = dp[j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
            }
        }

        return dp[n-1];
    }
}

