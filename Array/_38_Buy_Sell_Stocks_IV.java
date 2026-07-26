package Array;

public class _38_Buy_Sell_Stocks_IV {
    public static int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;
        int[] buy = new int[k];
        int[] sell = new int[k];
        java.util.Arrays.fill(buy, Integer.MAX_VALUE);
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                buy[i] = Math.min(buy[i], price - (i > 0 ? sell[i - 1] : 0));
                sell[i] = Math.max(sell[i], price - buy[i]);
            }
        }
        return sell[k - 1];
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        System.out.println("Max profit (k=2): " + maxProfit(2, prices));
    }
}
