package DynamicProgramming;

import java.util.*;

class MinimumJumpsToEnd {
    static int minJumps(int arr[], int n) {
        // Array to store the minimum jumps required to reach each index
        int dp[] = new int[n];

        // Initialize all positions with a large value (infinity equivalent)
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Starting position requires 0 jumps
        dp[0] = 0;

        // Traverse the array to fill dp[]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if index j can reach index i
                if (j + arr[j] >= i && dp[j] != Integer.MAX_VALUE) {
                    // Update dp[i] with the minimum jumps required
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        // Return the minimum jumps required to reach the last index
        return dp[n - 1];
    }

    public static void main(String args[]) {
        int arr[] = {3, 4, 2, 1, 2, 1, 3};
        int n = arr.length;

        int result = minJumps(arr, n);
        System.out.println("Minimum jumps to reach the end: " + result);
    }
}
