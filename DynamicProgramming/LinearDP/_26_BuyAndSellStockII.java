package DynamicProgramming.LinearDP;

/**
 * LeetCode 122: Best Time to Buy and Sell Stock II
 * You may complete as many transactions as you like.
 * You must sell before you buy again.
 *
 * Greedy: Add up all positive differences (every upward slope is profit)
 * DP: dp[i][0] = max profit on day i without stock, dp[i][1] = with stock
 */
public class _26_BuyAndSellStockII {

    // Greedy approach
    public static int maxProfitGreedy(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    // DP approach
    public static int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;            // Day 0, no stock held
        dp[0][1] = -prices[0];   // Day 0, stock held (bought)

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // sell or skip
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // buy or hold
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Greedy): " + maxProfitGreedy(prices)); // Output: 7
        System.out.println("Max Profit (DP):     " + maxProfitDP(prices));     // Output: 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Max Profit (Greedy): " + maxProfitGreedy(prices2)); // Output: 4
    }
}
