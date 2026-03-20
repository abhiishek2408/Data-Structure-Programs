/*Sure! Here are the steps for Kadane's Algorithm in a concise format:
The approach used in the code you provided is known as Kadane's Algorithm. This algorithm is designed to 
find the maximum sum of a contiguous subarray within a one-dimensional array of numbers. It operates with 
a time complexity of O(n), making it very efficient for this problem. The key idea is to iterate 
through the array while maintaining a running sum of the current subarray and 
updating the maximum sum found so far.The approach used in the code you provided 
is known as Kadane's Algorithm. This algorithm is designed to find the maximum sum 
of a contiguous subarray within a one-dimensional array of numbers. It operates with 
a time complexity of O(n), making it very efficient for this problem. The key idea is 
to iterate through the array while maintaining a running sum of the current subarray 
and updating the maximum sum found so far.

Steps:
Initialize: Set currSum and maxSum to the first element of the array
Iterate: Loop through the array starting from the second element.
Update currSum: Set currSum to the maximum of the current element and currSum + current element.
Update maxSum: Set maxSum to the maximum of maxSum and currSum.
Return: After the loop, return maxSum as the result. */

class MaxSubArray_Sum__KadaneI {
    public int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
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
        MaxSubArray_Sum__KadaneI solution = new MaxSubArray_Sum__KadaneI();

        // Example test case
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result = solution.maxSubArray(nums);

        System.out.println("The maximum subarray sum is: " + result);
    }
}