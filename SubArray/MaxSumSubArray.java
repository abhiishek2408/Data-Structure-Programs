
class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        // Check if the array is empty
        if (nums.length == 0) {
            return 0; // or throw an exception, depending on how you want to handle this case
        }

        int currSum = nums[0];
        int maxSum = nums[0];

        // Start the loop from the second element
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumSubArray solution = new MaxSumSubArray();

        // Example test case
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = solution.maxSubArray(nums);

        System.out.println("The maximum subarray sum is: " + result);
    }
}