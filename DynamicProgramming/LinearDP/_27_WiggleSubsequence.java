package DynamicProgramming.LinearDP;

/**
 * LeetCode 376: Wiggle Subsequence
 * A wiggle sequence alternates between going up and going down.
 * Given an integer array nums, return the length of the longest wiggle subsequence.
 *
 * up[i]   = length of longest wiggle subsequence ending at i with a rise
 * down[i] = length of longest wiggle subsequence ending at i with a fall
 */
public class _27_WiggleSubsequence {

    // DP approach O(n)
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int up = 1, down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 4, 9, 2, 5};
        System.out.println("Wiggle Length: " + wiggleMaxLength(nums1)); // Output: 6

        int[] nums2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println("Wiggle Length: " + wiggleMaxLength(nums2)); // Output: 7

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Wiggle Length: " + wiggleMaxLength(nums3)); // Output: 2
    }
}
