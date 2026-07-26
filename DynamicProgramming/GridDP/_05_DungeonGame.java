package DynamicProgramming.GridDP;

/**
 * LeetCode 174: Dungeon Game
 * The knight has an initial health point. He needs to travel from
 * top-left to bottom-right of a grid. Each cell has a value that
 * increases or decreases his health.
 * Find the minimum initial health to survive the journey (health > 0 at all times).
 *
 * Key: Work BACKWARDS from bottom-right to top-left.
 * dp[i][j] = minimum health needed when entering cell (i, j)
 */
public class _05_DungeonGame {

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        // Bottom-right corner
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        // Last column (can only go down)
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        // Last row (can only go right)
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        // Fill rest bottom-up, right-to-left
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minHealthNeeded = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minHealthNeeded - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };
        System.out.println("Minimum Initial Health: " + calculateMinimumHP(dungeon)); // Output: 7
    }
}
