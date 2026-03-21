//in this program we are given an array of binary numbers and an integer k, we have to find the longest subarray
//  that contains at most k zeros.
// For example, if the input array is [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] and k = 2, the longest subarray with at most 2 zeros is [1, 1, 1, 0, 0, 1, 1, 1], which has a length of 8.

public class SlidingWindow {
    
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zerosCount = 0;
        int maxLength = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zerosCount++;
            }

            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
