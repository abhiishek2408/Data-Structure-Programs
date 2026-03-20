package ETPquestion;

public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        double currentSum = 0;

        // Calculate initial sum of first 'k' elements
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        maxSum = currentSum;

        // Slide the window from index k to the end
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;  // Return average
    }

    public static void main(String[] args) {
        MaxAverageSubarray sol = new MaxAverageSubarray();

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println(sol.findMaxAverage(nums, k)); // Output: 12.75
    }
}
