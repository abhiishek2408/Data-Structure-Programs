package SlidingWindow;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for(int right = 0; right < nums.length; right++) {

            // If we encounter zero
            if(nums[right] == 0)
                zeros++;

            // If zeros exceed k, shrink window
            while(zeros > k) {

                if(nums[left] == 0)
                    zeros--;

                left++;
            }

            // Update maximum window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println(longestOnes(nums, k));
    }
}
