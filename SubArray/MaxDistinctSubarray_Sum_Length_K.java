import java.util.HashSet;

public class MaxDistinctSubarray_Sum_Length_K {
    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        // If the array has fewer elements than k, we cannot form a subarray of size k
        if (n < k) return 0; 

        long maxSum = 0;  // Variable to store the maximum sum found
        long currSum = 0; // Variable to store the current window sum
        HashSet<Integer> set = new HashSet<>(); // HashSet to keep track of unique elements in the window

        int left = 0; // Left pointer for the sliding window
        
        // Iterate over the array using the right pointer
        for (int right = 0; right < n; right++) {
            
            // If the current number is already in the set (not unique)
            // OR if the window size exceeds k, shrink the window from the left
            while (set.contains(nums[right]) || (right - left + 1 > k)) {
                set.remove(nums[left]); // Remove the leftmost element from the set
                currSum -= nums[left];  // Subtract it from the current sum
                left++;                 // Move the left pointer forward
            }

            // Add the current element to the set and include it in the current sum
            set.add(nums[right]);
            currSum += nums[right];

            // If the window size becomes exactly k, update the maxSum
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum; // Return the maximum sum found
    }

    public static void main(String[] args) {
        
    }
}


