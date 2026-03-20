package Array;

// GetMaximumInGeneratedArray.java
// Problem: Get Maximum in Generated Array (LeetCode style)

public class GetMaximumInGeneratedArray {
    /**
     * Generates the array as per the rules and returns the maximum value.
     * @param n The input integer
     * @return The maximum integer in the generated array
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        if (n >= 1) nums[1] = 1;
        int max = 1;
        for (int i = 1; 2 * i <= n || 2 * i + 1 <= n; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
                max = Math.max(max, nums[2 * i]);
            }
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[2 * i + 1]);
            }
        }
        return max;
    }

        // Alternative implementation using direct even/odd index approach
    public int getMaximumGeneratedAlt(int n) {
        if (n == 0) return 0;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        if (n >= 1) nums[1] = 1;

        int max = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[i / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }
    

    // Example usage
    public static void main(String[] args) {
        GetMaximumInGeneratedArray solution = new GetMaximumInGeneratedArray();
        int n = 7;
        int max = solution.getMaximumGenerated(n);
        System.out.println("Maximum in generated array for n = " + n + ": " + max);
    }
}
