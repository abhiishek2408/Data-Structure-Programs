package DynamicProgramming;


class MinimumCoins {
    // Recursive function to find the minimum number of coins
    static int getMin(int coins[], int n, int val) {
        // Base case: If value is 0, no coins are needed
        if (val == 0) return 0;

        // Initialize result to a large number
        int res = Integer.MAX_VALUE;

        // Try every coin that is smaller than or equal to val
        for (int i = 0; i < n; i++) {
            if (coins[i] <= val) {
                int subRes = getMin(coins, n, val - coins[i]);

                // Check if subRes is not Integer.MAX_VALUE to avoid overflow
                if (subRes != Integer.MAX_VALUE)
                    res = Math.min(res, subRes + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int coins[] = {25, 10, 5};  // Coin denominations
        int val = 30;  // Value to make
        int n = coins.length;

        int result = getMin(coins, n, val);
        System.out.println("Minimum coins required: " + result);
    }
}
