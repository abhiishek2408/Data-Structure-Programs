package SlidingWindow;
//Longest Subarray with Sum ≤ K
// leetcode 1004
public class LongestSubarraywithSumK {
    public static int longestSubarray(int arr[], int k) {

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for(int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while(sum > k) {
                sum -= arr[left];
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int arr[] = {2,1,3,2,4};
        int k = 5;

        System.out.println(longestSubarray(arr, k));
    }
}
