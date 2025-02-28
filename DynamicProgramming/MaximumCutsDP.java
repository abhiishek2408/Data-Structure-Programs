package DynamicProgramming;

import java.util.*;

class MaximumCutsDP {
    // Function to find the maximum number of cuts using Dynamic Programming
    static int maxCuts(int n, int a, int b, int c) {
        // Create a DP array of size (n + 1) initialized to -1
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        // Base case: If the length is 0, no cuts are needed
        dp[0] = 0;

        // Iterate through all lengths from 1 to n
        for (int i = 1; i <= n; i++) {
            // Try all possible cuts
            if (i - a >= 0 && dp[i - a] != -1)
                dp[i] = Math.max(dp[i], dp[i - a]);

            if (i - b >= 0 && dp[i - b] != -1)
                dp[i] = Math.max(dp[i], dp[i - b]);

            if (i - c >= 0 && dp[i - c] != -1)
                dp[i] = Math.max(dp[i], dp[i - c]);

            // If a valid cut was found, increase the count
            if (dp[i] != -1)
                dp[i]++;
        }

        // Return the maximum cuts possible for length n
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5, a = 1, b = 2, c = 3;
        System.out.println("Maximum cuts possible: " + maxCuts(n, a, b, c));
    }
}
