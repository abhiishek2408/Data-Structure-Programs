
public class MaxSubArray_Sum_Length_K_SlidingWindow {
    public static int maxSum(int[] arr, int n, int k) {
        
        if (n < k) {
            System.out.println("Invalid input: Array size is less than the subarray size.");
            return -1;
        }

        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }

        int maxSum = currSum;

        for (int i = k; i < n; i++) {              // Sliding window technique
            currSum = currSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, currSum); 
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, -2, 20, 1};
        int k = 3;
        int n = arr.length;

        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSum(arr, n, k));
    }
}

