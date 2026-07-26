package DynamicProgramming.LinearDP;

/**
 * LeetCode 256: Paint House (Premium/Classic)
 * There are n houses in a row. Each house can be painted with one of 3 colors:
 * Red, Blue, or Green. The cost of painting each house with a certain color is
 * given by an n x 3 cost matrix.
 * No two adjacent houses can have the same color.
 * Find the minimum total cost to paint all houses.
 *
 * dp[i][j] = cost[i][j] + min(dp[i-1][other colors])
 */
public class _20_PaintHouse {

    public static int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length;
        int[][] dp = new int[n][3];

        // Base case: first house
        dp[0][0] = costs[0][0]; // Red
        dp[0][1] = costs[0][1]; // Blue
        dp[0][2] = costs[0][2]; // Green

        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    // Space Optimized approach
    public static int minCostOptimized(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int prevRed = costs[0][0];
        int prevBlue = costs[0][1];
        int prevGreen = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int currRed = costs[i][0] + Math.min(prevBlue, prevGreen);
            int currBlue = costs[i][1] + Math.min(prevRed, prevGreen);
            int currGreen = costs[i][2] + Math.min(prevRed, prevBlue);

            prevRed = currRed;
            prevBlue = currBlue;
            prevGreen = currGreen;
        }

        return Math.min(prevRed, Math.min(prevBlue, prevGreen));
    }

    public static void main(String[] args) {
        int[][] costs = {
            {17, 2, 17},
            {16, 16, 5},
            {14, 3, 19}
        };
        System.out.println("Min cost (Tabulation): " + minCost(costs));       // Output: 10
        System.out.println("Min cost (Optimized):  " + minCostOptimized(costs)); // Output: 10
    }
}
