package Recursion;

public class CountSubsetsSum {
    
    public static int countSubsets(int[] nums, int n, int sum) {
        if (sum == 0) return 1; // Found a valid subset
        if (n == 0) return 0; // No elements left to consider
        
        // If the last element is greater than the remaining sum, ignore it
        if (nums[n - 1] > sum) 
            return countSubsets(nums, n - 1, sum);

        // Include the last element in the subset OR exclude it
        return countSubsets(nums, n - 1, sum - nums[n - 1]) + countSubsets(nums, n - 1, sum);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 8, 10};
        int target = 10;
        System.out.println("Total subsets with sum " + target + ": " + countSubsets(nums, nums.length, target));
    }
}
