package DynamicProgramming;
//Problem: Climbing Stairs
//You are climbing a staircase. It takes n steps to reach the top. 
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//Find the number of distinct ways to climb to the top of the staircase.

public class ClimbingStair {

    //Memoization approach to solve the climbing stairs problem
    public int climbStairsMemoization(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        return climbStairsHelper(n, dp);
    }

    private int climbStairsHelper(int n, int[] dp) {
        if (n <= 2) return n;
        if (dp[n] != 0) return dp[n];

        dp[n] = climbStairsHelper(n - 1, dp) + climbStairsHelper(n - 2, dp);
        return dp[n];
    }
    
    //Tabulation approach to solve the climbing stairs problem
    public int climbStairsTabulation(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


//Approach 2: Space Optimized solution to solve the climbing stairs problem
    public int climbStairsOptimized(int n) {
        if (n <= 2) return n;

        int prev2 = 1; // ways(1)
        int prev1 = 2; // ways(2)

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}


//dp[i] = dp[i-1] + dp[i-2] + dp[i-3] if we can climb 1, 2 or 3 steps at a time. 
// This is a generalization of the problem where we can climb more than 2 steps at a time.