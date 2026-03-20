
    public class MaxSubArray_Sum__Naive {

    // Function to find the sum of subarray with maximum sum
    static int maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
  

        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
      
            // Inner loop for ending point of subarray
            for (int j = i; j < arr.length; j++) {
                currSum = currSum + arr[j];
                // Update res if currSum is greater than res
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }
}

