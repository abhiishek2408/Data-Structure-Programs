package DynamicProgramming.LinearDP;

/**
 * LeetCode 152: Maximum Product Subarray
 * Given an integer array nums, find a subarray that has the largest product,
 * and return the product.
 *
 * Key Insight: Track both max and min at each step because a negative number
 * can flip min to max when multiplied.
 */
public class _22_MaxProductSubarray {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // If current element is negative, swap max and min
            if (nums[i] < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(nums[i], maxSoFar * nums[i]);
            minSoFar = Math.min(nums[i], minSoFar * nums[i]);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Max Product: " + maxProduct(nums1)); // Output: 6

        int[] nums2 = {-2, 0, -1};
        System.out.println("Max Product: " + maxProduct(nums2)); // Output: 0

        int[] nums3 = {-2, 3, -4};
        System.out.println("Max Product: " + maxProduct(nums3)); // Output: 24
    }
}
