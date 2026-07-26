package DynamicProgramming.LinearDP;

/**
 * LeetCode 121: Best Time to Buy and Sell Stock I
 * You are given an array prices where prices[i] is the price of a stock on day i.
 * You want to maximize your profit by choosing a single day to buy and a
 * single day in the future to sell. Return the maximum profit.
 *
 * dp[i] = max profit if we sell on day i = prices[i] - minSoFar
 */
public class _25_BuyAndSellStockI {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + maxProfit(prices1)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit: " + maxProfit(prices2)); // Output: 0
    }
}
