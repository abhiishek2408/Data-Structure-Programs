package DynamicProgramming.GridDP;

/**
 * LeetCode 120: Triangle (Minimum Path Sum)
 * Given a triangle array, return the minimum path sum from top to bottom.
 * At each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move
 * to either index i or index i + 1 on the next row.
 */
public class _04_Triangle {

    // Tabulation (Bottom-Up)
    public static int minimumTotal(java.util.List<java.util.List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize dp with the last row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Build from bottom to top
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        java.util.List<java.util.List<Integer>> triangle = java.util.Arrays.asList(
            java.util.Arrays.asList(2),
            java.util.Arrays.asList(3, 4),
            java.util.Arrays.asList(6, 5, 7),
            java.util.Arrays.asList(4, 1, 8, 3)
        );
        System.out.println("Minimum Path Sum: " + minimumTotal(triangle)); // Output: 11 (2→3→5→1)
    }
}
