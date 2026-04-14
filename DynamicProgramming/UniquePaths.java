package DynamicProgramming;
// LeetCode 62. Unique Paths
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram).
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram).
// How many possible unique paths are there? 
// Total kitne different paths hain end tak pahuchne ke liye?
// Each cell represents number of ways to reach that cell. So, for each cell, we can reach it from the top cell or from the left cell. Hence, dp[i][j] = dp[i-1][j] + dp[i][j-1]

public class UniquePaths {
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Base cases: There is only one way to reach any cell in the first row or first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    // Optimized space complexity to O(n)
    public int uniquePathsOptimized(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    public int uniquePaths1D(int m, int n) {
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3, n = 7;
        System.out.println("Number of unique paths from top-left to bottom-right: " + solution.uniquePaths(m, n));
    }
}
