package DynamicProgramming.DecisionMaking;

/**
 * LeetCode 474: Ones and Zeroes
 * You are given an array of binary strings strs and two integers m and n.
 * Return the size of the largest subset of strs such that there are
 * at most m 0's and n 1's in the subset.
 *
 * This is a 2D Knapsack problem: two constraints (zeros and ones) instead of one (weight).
 * dp[i][j] = max subset size using at most i zeros and j ones
 */
public class _11_OnesAndZeroes {

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            // Traverse backwards (0/1 knapsack pattern)
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println("Max subset size: " + findMaxForm(strs, m, n)); // Output: 4

        String[] strs2 = {"10", "0", "1"};
        System.out.println("Max subset size: " + findMaxForm(strs2, 1, 1)); // Output: 2
    }
}
