package DynamicProgramming.DecisionMaking;

/**
 * Count Subsets with Given Difference
 * Given an array and a difference d, count the number of subsets
 * that can be divided into two groups S1 and S2 such that S1 - S2 = d.
 *
 * Key Insight: S1 + S2 = totalSum, S1 - S2 = d
 * So S1 = (totalSum + d) / 2 → reduce to "Count Subsets with Sum = S1"
 */
public class _09_CountSubsetsWithDiff {

    public static int countSubsets(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        // S1 = (totalSum + diff) / 2
        if ((totalSum + diff) % 2 != 0 || totalSum + diff < 0) return 0;
        int target = (totalSum + diff) / 2;

        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // exclude
                if (j >= arr[i - 1]) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]]; // include
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        System.out.println("Count subsets with diff " + diff + ": " + countSubsets(arr, diff)); // Output: 3
    }
}
