package TwoPointer;

import java.util.Arrays;

public class TwoSum {
    
    public boolean twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return true; 
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public String twoSumPairs(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        StringBuilder pairs = new StringBuilder();

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                pairs.append("(").append(nums[left]).append(", ").append(nums[right]).append(") ");
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs.toString().trim();
    }


    public int[] twoSumIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {10, 15, 3, 7};
        int target = 17;

        boolean result = solution.twoSum(nums, target);
        System.out.println("Two sum exists: " + result);
    }
}
