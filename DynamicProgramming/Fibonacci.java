package DynamicProgramming;

//Problem: Fibonacci Number
//The Fibonacci numbers are the numbers in the following integer sequence:
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
//The Fibonacci numbers are defined by the following recurrence relation: F(n) = F(n-1) + F(n-2), with F(0) = 0 and F(1) = 1

public class Fibonacci {

    //Memoization approach to solve the Fibonacci problem
    public static int fibMemoization(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        return fibHelper(n, dp);
    }

    private static int fibHelper(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];

        dp[n] = fibHelper(n - 1, dp) + fibHelper(n - 2, dp);
        return dp[n];
    }

    
    //Tabulation approach to solve the Fibonacci problem
    public static int fibTabulation(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    //Space Optimized approach to solve the Fibonacci problem
    public static int fibOptimized(int n) {
        if (n <= 1) return n;

        int prev2 = 0; // fib(0)
        int prev1 = 1; // fib(1)

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n = 10; // Example: Find the 10th Fibonacci number
        System.out.println("Fibonacci of " + n + " is " + fibOptimized(n));
    }
}



