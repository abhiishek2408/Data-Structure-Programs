package DynamicProgramming.DecisionMaking;

/**
 * LeetCode 1049: Last Stone Weight II
 * You have a collection of stones. Each turn, you choose two stones
 * and smash them together. The result is |weight1 - weight2|.
 * Return the smallest possible weight of the remaining stone.
 *
 * Key Insight: This is equivalent to partitioning stones into two groups
 * and minimizing |S1 - S2|. Same as "Minimum Subset Sum Difference".
 * Find the largest subset sum <= totalSum/2 → answer = totalSum - 2*closest
 */
public class _10_LastStoneWeightII {

    public static int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int s : stones) totalSum += s;

        int half = totalSum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int stone : stones) {
            for (int j = half; j >= stone; j--) {
                dp[j] = dp[j] || dp[j - stone];
            }
        }

        // Find largest sum <= half
        int closest = 0;
        for (int j = half; j >= 0; j--) {
            if (dp[j]) {
                closest = j;
                break;
            }
        }

        return totalSum - 2 * closest;
    }

    public static void main(String[] args) {
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Last Stone Weight: " + lastStoneWeightII(stones1)); // Output: 1

        int[] stones2 = {31, 26, 33, 21, 40};
        System.out.println("Last Stone Weight: " + lastStoneWeightII(stones2)); // Output: 5
    }
}
