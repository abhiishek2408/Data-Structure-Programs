
public class maxSubArray {
    public static void main(String[] args) {
        maxSubArray solution = new maxSubArray();

        // Test array
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Call the method and print the result
        int result = solution.FindmaxSubArray(nums);
        System.out.println("Maximum subarray sum is: " + result);
    }

    public int FindmaxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0; // Start index of the maximum subarray
        int end = 0; // End index of the maximum subarray
        int tempStart = 0; // A temporary variable to track a potential new subarray start index.

        for (int i = 1; i < nums.length; i++) { // If adding nums[i] to currentSum makes it smaller than nums[i] alone,
                                                // we reset currentSum to nums[i] and update tempStart.
            if (nums[i] > currentSum + nums[i]) { // This means it's better to start a new subarray from nums[i].
                currentSum = nums[i];
                tempStart = i;
            }

            else { // If adding nums[i] still increases currentSum, we continue with the current
                   // subarray.
                currentSum += nums[i];
            }

            if (currentSum > maxSum) { // If currentSum exceeds maxSum, update maxSum and record the start and end
                                       // indices of this subarray.
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Print the maximum subarray
        System.out.print("Maximum subarray is: [");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + (i == end ? "" : ", "));
        }
        System.out.println("]");

        return maxSum;
    }

}
