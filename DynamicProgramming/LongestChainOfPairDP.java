package DynamicProgramming;

import java.util.*;

    public class LongestChainOfPairDP {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;

        // Step 1: Sort the pairs based on the first value
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Apply LIS on the second values
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every element is at least part of a chain of length 1

        int maxChain = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) { // Check if non-overlapping
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxChain = Math.max(maxChain, dp[i]); // Update the max chain length
        }

        return maxChain;
    }

    public static void main(String[] args) {
        LongestChainOfPairDP sol = new LongestChainOfPairDP();
        int[][] pairs = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
        System.out.println(sol.findLongestChain(pairs)); // Expected Output: 3
    }
}

