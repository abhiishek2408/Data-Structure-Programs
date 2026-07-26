package DynamicProgramming.LinearDP;

/**
 * LeetCode 338: Counting Bits
 * Given an integer n, return an array ans of length n + 1 such that
 * for each i (0 <= i <= n), ans[i] is the number of 1's in the binary
 * representation of i.
 *
 * dp[i] = dp[i >> 1] + (i & 1)
 * The number of bits in i = bits in i/2 + last bit of i
 */
public class _19_CountingBits {

    // Tabulation approach
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);
        System.out.print("Counting Bits for n = " + n + ": ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: 0 1 1 2 1 2
    }
}
