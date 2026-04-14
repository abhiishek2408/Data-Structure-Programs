package DynamicProgramming;
// LeetCode 63. Unique Paths II
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram).
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and space is marked as 1 and 0 respectively in the grid. For example, there is one obstacle in the middle of a 3x3 grid as illustrated below.
// There is one obstacle in the middle of a 3x3 grid as illustrated below
// 0 0 0
// 0 1 0
// 0 0 0
// The total number of unique paths that are able to reach the bottom-right corner is 2
// Each cell represents number of ways to reach that cell. So, for each cell, we can reach 
// it from the top cell or from the left cell. Hence, dp[i][j] = dp[i-1][j] + dp[i][j-1] 
// if there is no obstacle in that cell. If there is an obstacle, then dp[i][j] = 0

public class UniquePathsII {
     public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // starting cell
        if (grid[0][0] == 1) return 0;
        dp[0][0] = 1;

        // first column
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 0)
                dp[i][0] = dp[i-1][0];
        }

        // first row
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == 0)
                dp[0][j] = dp[0][j-1];
        }

        // rest cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    // Optimized space complexity to O(n)
    public int uniquePathsWithObstaclesOptimized(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = (grid[0][0] == 0) ? 1 : 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println("Number of unique paths from top-left to bottom-right with obstacles: " + solution.uniquePathsWithObstacles(grid));
        System.out.println("Number of unique paths (optimized space complexity): " + solution.uniquePathsWithObstaclesOptimized(grid));
    }

}
