package DynamicProgramming.LinearDP;

/**
 * LeetCode 276: Paint Fence
 * You are painting a fence of n posts with k colors.
 * You must paint all posts such that no more than TWO adjacent posts
 * have the same color. Return the total number of ways to paint the fence.
 *
 * same[i]  = diff[i-1]                (paint i same as i-1 → i-1 must differ from i-2)
 * diff[i]  = (same[i-1] + diff[i-1]) * (k-1)
 * total[i] = same[i] + diff[i]
 */
public class _21_PaintFence {

    public static int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;

        // same = ways where post i and i-1 have the same color
        // diff = ways where post i and i-1 have different colors
        int same = k;           // For 2 posts, same = k (each of k colors once)
        int diff = k * (k - 1); // For 2 posts, diff = k*(k-1)

        for (int i = 3; i <= n; i++) {
            int prevSame = same;
            same = diff;
            diff = (prevSame + diff) * (k - 1);
        }

        return same + diff;
    }

    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println("Number of ways to paint " + n + " posts with " + k + " colors: " + numWays(n, k));
        // Output: 6

        System.out.println("n=4, k=2: " + numWays(4, 2)); // Output: 10
    }
}
