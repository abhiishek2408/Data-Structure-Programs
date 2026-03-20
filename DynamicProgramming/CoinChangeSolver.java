package DynamicProgramming;

//method calculating the minimum number of coins needed to make a specified amount 

class CoinChangeSolver {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        // Initialize dp array with a value greater than any possible number of coins
        for (int i = 0; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0; // Base case: 0 coins needed to make amount 0

        // Fill the dp array
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // If dp[amount] is still max, it means it's not possible to make that amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeSolver solver = new CoinChangeSolver();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = solver.coinChange(coins, amount);
        if (result != -1) {
            System.out.println("Minimum number of coins needed: " + result);
        } else {
            System.out.println("It's not possible to make the amount with the given coins.");
        }
    }
}