public class MaxSubArray_Sum_And_SubArray {
    public static void maxSumSubarrayWithIndices(int[] nums) {
        // Check if the array is empty
        if (nums.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int currSum = nums[0];
        int maxSum = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        // Start the loop from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currSum + nums[i]) {   // This means it's better to start a new subarray from nums[i].
                currSum = nums[i];
                tempStart = i;
            } else {                   //If adding nums[i] still increases currentSum, we continue with the current subarray
                currSum += nums[i];
            }

            if (currSum > maxSum) {        // If currentSum exceeds maxSum, update maxSum and record the start and end
                maxSum = currSum;
                start = tempStart;
                end = i;
            }
        }

        // Print the results after the loop
        System.out.println("Maximum Sum: " + maxSum);
        System.out.print("Subarray: ");
        for (int k = start; k <= end; k++) {
            System.out.print(nums[k] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSumSubarrayWithIndices(nums);
    }
}