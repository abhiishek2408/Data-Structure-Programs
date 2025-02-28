package DynamicProgramming;

class KnapsackDP {
    // Function to solve 0-1 Knapsack using Dynamic Programming
    static int knapsack(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                // Base case: If no items or capacity is zero, value is 0
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                // If the weight of the current item is more than capacity, exclude it
                else if (wt[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                // Otherwise, take the maximum of including or excluding the item
                else
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
            }
        }

        return dp[n][W]; // Maximum value that can be obtained
    }

    public static void main(String args[]) {
        int val[] = {10, 40, 30, 50};  // Values of items
        int wt[] = {5, 4, 6, 3};       // Weights of items
        int W = 10;                    // Knapsack capacity
        int n = val.length;            // Number of items

        int maxProfit = knapsack(W, wt, val, n);
        System.out.println("Maximum value in Knapsack = " + maxProfit);
    }
}
