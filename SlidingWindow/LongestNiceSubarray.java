package SlidingWindow;

public class LongestNiceSubarray {
//We use Sliding Window + Bitmask.
//The bitmask is used to keep track of the bits that are set in the current window.
//bitMask: which stores the OR of all elements in the window.

/*If adding a new number causes:
(bitMask & nums[right]) != 0
then two numbers share a bit → shrink window.

Algorithm
Use two pointers left and right
Maintain bitMask
If conflict occurs:
remove elements from left
Update max length.

*/

    public static int longestNiceSubarray(int[] nums) {

        int left = 0;
        int bitMask = 0;
        int maxLen = 0;

        for(int right = 0; right < nums.length; right++) {

            while((bitMask & nums[right]) != 0) {

                bitMask ^= nums[left];
                left++;
            }

            bitMask |= nums[right];

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int nums[] = {1,3,8,48,10};

        System.out.println(longestNiceSubarray(nums));
    }
}
