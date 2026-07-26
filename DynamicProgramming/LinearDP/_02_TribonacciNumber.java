package DynamicProgramming.LinearDP;

public class _02_TribonacciNumber {

    //Memoization approach to solve the Tribonacci problem
    private static int tribHelper(int n, int[] dp) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != 0) return dp[n];

        dp[n] = tribHelper(n - 1, dp) + tribHelper(n - 2, dp) + tribHelper(n - 3, dp);
        return dp[n];
    }

    public static int tribonacciMemoization(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] dp = new int[n + 1];
        return tribHelper(n, dp);
    }

    //Tabulation approach to solve the Tribonacci problem
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    //Space Optimized approach to solve the Tribonacci problem
    public static int tribonacciOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int prev3 = 0, prev2 = 1, prev1 = 1;

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        _02_TribonacciNumber tribonacciNumber = new _02_TribonacciNumber();
        int n = 25;
        System.out.println("Memoization:      The " + n + "th Tribonacci number is: " + tribonacciMemoization(n));
        System.out.println("Tabulation:       The " + n + "th Tribonacci number is: " + tribonacciNumber.tribonacci(n));
        System.out.println("Space Optimized:  The " + n + "th Tribonacci number is: " + tribonacciOptimized(n));
    }
}
