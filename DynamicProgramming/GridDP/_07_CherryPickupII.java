package DynamicProgramming.GridDP;

/**
 * LeetCode 1463: Cherry Pickup II
 * You have a rows x cols grid. Two robots start at (0,0) and (0,cols-1).
 * Both robots move down one row at a time and can go left-diagonal, straight, or right-diagonal.
 * They collect cherries from each cell they visit (cell becomes 0 after).
 * Return the maximum cherries both robots can collect.
 *
 * 3D DP: dp[row][c1][c2] = max cherries when robot1 is at col c1 and robot2 at col c2 in given row
 */
public class _07_CherryPickupII {

    public static int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        // Initialize with -1
        for (int[][] layer : dp)
            for (int[] row : layer)
                java.util.Arrays.fill(row, -1);

        dp[0][0][cols - 1] = grid[0][0] + grid[0][cols - 1];

        for (int r = 1; r < rows; r++) {
            for (int c1 = 0; c1 < cols; c1++) {
                for (int c2 = 0; c2 < cols; c2++) {
                    int best = -1;
                    // Try all 9 combinations of previous positions
                    for (int dc1 = -1; dc1 <= 1; dc1++) {
                        for (int dc2 = -1; dc2 <= 1; dc2++) {
                            int pc1 = c1 + dc1, pc2 = c2 + dc2;
                            if (pc1 >= 0 && pc1 < cols && pc2 >= 0 && pc2 < cols
                                && dp[r - 1][pc1][pc2] != -1) {
                                best = Math.max(best, dp[r - 1][pc1][pc2]);
                            }
                        }
                    }
                    if (best != -1) {
                        int cherries = (c1 == c2) ? grid[r][c1] : grid[r][c1] + grid[r][c2];
                        dp[r][c1][c2] = best + cherries;
                    }
                }
            }
        }

        int result = 0;
        for (int c1 = 0; c1 < cols; c1++)
            for (int c2 = 0; c2 < cols; c2++)
                if (dp[rows - 1][c1][c2] != -1)
                    result = Math.max(result, dp[rows - 1][c1][c2]);

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
        };
        System.out.println("Maximum Cherries: " + cherryPickup(grid)); // Output: 24
    }
}
