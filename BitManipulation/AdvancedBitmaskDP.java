import java.util.Arrays;

public class AdvancedBitmaskDP {
    // Minimum assignment cost: worker i receives one unused job j.
    static int minimumAssignmentCost(int[][] cost) {
        int n = cost.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            int worker = Integer.bitCount(mask);
            if (worker == n) continue;
            for (int job = 0; job < n; job++) {
                if ((mask & (1 << job)) == 0) {
                    int nextMask = mask | (1 << job);
                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + cost[worker][job]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    public static void main(String[] args) {
        int[][] cost = {
            {9, 2, 7, 8},
            {6, 4, 3, 7},
            {5, 8, 1, 8},
            {7, 6, 9, 4}
        };
        System.out.println("Minimum assignment cost: " + minimumAssignmentCost(cost));
        System.out.println("Complexity: O(n * 2^n), suitable for roughly n <= 20");
    }
}
