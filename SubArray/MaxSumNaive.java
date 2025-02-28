
public class MaxSumNaive {
    public static int maxSum(int[] arr, int n, int k) {
        int res = Integer.MIN_VALUE; // Equivalent to INT.MIN in Java

        // Loop over all starting points
        for (int i = 0; i <= n - k; i++) {
            int currSum = 0;

            for (int j = 0; j < k; j++) {// Calculate sum of subarray of size k
                currSum += arr[i + j];
            }

            // Update the result with the maximum sum found
            res = Math.max(res, currSum);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, -2, 20, 1};
        int k = 3;
        int n = arr.length;

        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSum(arr, n, k));
    }
}
