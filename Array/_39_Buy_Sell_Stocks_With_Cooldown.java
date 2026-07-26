package Array;

public class _39_Buy_Sell_Stocks_With_Cooldown {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println("Max profit with cooldown: " + maxProfit(prices));
    }
}
