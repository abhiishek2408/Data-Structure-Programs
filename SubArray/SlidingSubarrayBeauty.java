/*Given an integer array nums containing n integers, find the beauty of each subarray of size k.

The beauty of a subarray is the xth smallest integer in the subarray if it is negative, or 0 if 
there are fewer than x negative integers.

Return an integer array containing n - k + 1 integers, which denote the beauty of the subarrays 
in order from the first index in the array.

A subarray is a contiguous non-empty sequence of elements within an array. */



class SlidingSubarrayBeauty {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] freq = new int[101]; // For range [-50, 50], indexed from 0 to 100

        // Initialize first window
        for (int i = 0; i < k; i++) {
            freq[nums[i] + 50]++;
        }
        result[0] = getXthSmallestNegative(freq, x);

        // Slide the window
        for (int i = k; i < n; i++) {
            freq[nums[i - k] + 50]--; // Remove the outgoing element
            freq[nums[i] + 50]++; // Add the new element
            result[i - k + 1] = getXthSmallestNegative(freq, x);
        }

        return result;
    }

    // Helper function to find the x-th smallest negative number
    private int getXthSmallestNegative(int[] freq, int x) {
        int count = 0;
        for (int i = 0; i < 50; i++) { // Only check negative numbers (indices 0 to 49)
            count += freq[i];
            if (count >= x) return i - 50; // Convert index back to actual value
        }
        return 0; // If there are fewer than x negative numbers
    }
}
