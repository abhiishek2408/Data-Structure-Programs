package DynamicProgramming;

public class MatrixChainMultiplicationTabulation {
    // Function to find the minimum number of multiplications using tabulation
    public static int matrixChainOrder(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Fill dp array with 0 for single matrix (i == j)
        for (int i = 0; i < n; i++)
            dp[i][i] = 0;

        // `len` represents the chain length (starting from 2)
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                // Try different partitions
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1]; // Minimum cost to multiply matrices from 0 to n-1
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30}; // Example matrix dimensions

        System.out.println("Minimum number of multiplications: " + matrixChainOrder(arr));
    }
}
