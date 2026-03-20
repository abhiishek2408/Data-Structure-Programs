/*
Problem: Given an integer array nums and an integer k, return true if nums has a subarray 
of at least size two whose sum is a multiple of k. Otherwise, return false.

We use prefix sums and a HashMap to efficiently check if a subarray sum is a multiple of k.

Maintain a running sum (prefixSum).
Store the remainder (prefixSum % k) in a HashMap.
If the same remainder appears again at least two indices apart, we return true. */


import java.util.HashMap;

public class Continuous_Subarray_Sum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> remainderMap = new HashMap<>(); //Key: The remainder of prefixSum % k. && Value: The index where this remainder was first seen.
        remainderMap.put(0, -1); // Handles cases where the entire subarray sum is a multiple of k

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Update prefix sum
            int remainder = prefixSum % k; // Compute remainder when divided by k

            if (remainder < 0) { // Ensure the remainder is positive (Java handles negatives differently)
                remainder += k;
            }

            // Check if the remainder has been seen before
            if (remainderMap.containsKey(remainder)) {
                // Ensure the subarray length is at least 2
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Store the first occurrence of this remainder
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println(checkSubarraySum(nums1, k1)); // Output: true

        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println(checkSubarraySum(nums2, k2)); // Output: true

        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println(checkSubarraySum(nums3, k3)); // Output: false
    }

}
