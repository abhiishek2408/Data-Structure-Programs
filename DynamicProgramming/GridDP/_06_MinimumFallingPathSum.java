package DynamicProgramming.GridDP;

/**
 * LeetCode 931: Minimum Falling Path Sum
 * Given an n x n array of integers, return the minimum sum of any falling path.
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 */
public class _06_MinimumFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Copy first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int above = dp[i - 1][j];
                int aboveLeft = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int aboveRight = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(above, Math.min(aboveLeft, aboveRight));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        System.out.println("Minimum Falling Path Sum: " + minFallingPathSum(matrix)); // Output: 13 (1→5→7)
    }
}
