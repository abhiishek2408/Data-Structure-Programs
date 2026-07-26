package TwoPointerApproach;
public class TwoSumSorted {

    public static int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Two-pointer approach
        while (left < right) {
            int current = nums[left] + nums[right];

            if (current == target) {
                return new int[] {left, right};
            } 
            else if (current < target) {
                left++; 
            } 
            else {
                right--; 
            }
        }

        
        return new int[] {};// Return an empty array if no solution is found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6};
        int target = 6;
        int[] result = twoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}

