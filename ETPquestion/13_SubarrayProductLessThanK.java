package ETPquestion;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // Special case: no product can be < 1 if all nums are positive

        int count = 0;        // Final answer to store number of valid subarrays
        int left = 0;         // Left index of the sliding window
        int product = 1;      // Product of elements in current window

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right]; // Expand the window to the right

            // If product becomes >= k, shrink the window from the left
            while (product >= k && left <= right) {
                product /= nums[left]; // Remove nums[left] from the product
                left++;                // Move left pointer forward
            }

            // All subarrays ending at index 'right' and starting from 'left' to 'right' are valid
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(solution.numSubarrayProductLessThanK(nums, k)); // Output: 8
    }
}

