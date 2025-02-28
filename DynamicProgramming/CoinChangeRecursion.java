package DynamicProgramming;

public class CoinChangeRecursion {

    public static int countWays(int[] coins, int n, int s) {
        if (s == 0)
            return 1;
        if (s < 0)
            return 0;
        if (n == 0)
            return 0;
        return countWays(coins, n, s - coins[n - 1]) + countWays(coins, n - 1, s);
    }

    public static void main(String[] args) {
        int[] coins = {2, 5, 3};
        int n = coins.length;
        int s = 5;
        int ways = countWays(coins, n, s);
        System.out.println("Number of ways to make change: " + ways);
    }
}