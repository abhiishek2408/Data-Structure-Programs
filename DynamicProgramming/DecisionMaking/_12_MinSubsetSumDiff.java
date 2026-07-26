package DynamicProgramming.DecisionMaking;

/**
 * Minimum Subset Sum Difference
 * Given a set of integers, partition it into two subsets S1 and S2
 * such that the absolute difference of their sums is minimized.
 *
 * Approach: Find all possible subset sums up to totalSum/2,
 * then answer = totalSum - 2 * closest_sum_to_half
 */
public class _12_MinSubsetSumDiff {

    public static int minDifference(int[] arr) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        int half = totalSum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = half; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // Find the largest achievable sum <= half
        for (int j = half; j >= 0; j--) {
            if (dp[j]) {
                return totalSum - 2 * j;
            }
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 6, 11, 5};
        System.out.println("Min Difference: " + minDifference(arr1)); // Output: 1

        int[] arr2 = {3, 1, 4, 2, 2, 1};
        System.out.println("Min Difference: " + minDifference(arr2)); // Output: 1
    }
}
