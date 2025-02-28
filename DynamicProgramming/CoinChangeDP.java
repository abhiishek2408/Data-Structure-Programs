package DynamicProgramming;
//Determine the no. ways to to make a given sum `s` using an Infinite supply coins of given denominations
public class CoinChangeDP {
   
  public static int countWays(int[] coins, int n, int s) {
            int[][] dp = new int[n + 1][s + 1];
    
            // Initialize base cases
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1; // One way to make sum 0 (use no coins)
            }
            for (int j = 1; j <= s; j++) {
                dp[0][j] = 0; // No way to make positive sum with 0 coins
            }
    
            // Fill the dp table
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= s; j++) {
                    dp[i][j] = dp[i - 1][j]; // Exclude the coin
                    if (coins[i - 1] <= j) {
                        dp[i][j] += dp[i][j - coins[i - 1]]; // Include the coin
                    }
                }
            }
    
            return dp[n][s];
        }
    
        public static void main(String[] args) {
            int[] coins = {1, 2, 5};
            int n = coins.length;
            int s = 3;
            int ways = countWays(coins, n, s);
            System.out.println("Number of ways to make change: " + ways);
        }
    }

