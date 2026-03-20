package SlidingWindow;

public class MaxSumSubarray {

    public static int maxSum(int[] arr, int k) {

        int windowSum = 0;
        int maxSum = 0;

        // first window
        for(int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // sliding window
        for(int i = k; i < arr.length; i++) {
            windowSum +=  arr[i] - arr[i - k];  // add next element and remove first element of previous window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int arr[] = {2,1,5,1,3,2};
        int k = 3;

        System.out.println(maxSum(arr, k));
    }
}