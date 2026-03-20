package Array;
// Problem: Max Sum of a Pair With Equal Sum of Digits
// Given an array of integers, find the maximum sum of a pair of numbers such that both numbers have the same sum of digits.
// If no such pair exists, return -1.
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;

public class MaxSumPairWithEqualDigitSum {

     public int maximumSum(int[] nums) {
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (sumOfDigits(nums[i]) == sumOfDigits(nums[j])) {
                    max = Math.max(max, nums[i] + nums[j]);
                }
            }
        }
        return max;
    }

    public static int maxSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int num : nums) {
            int digitSum = sumOfDigits(num);
            
            if (map.containsKey(digitSum)) {
                max = Math.max(max, map.get(digitSum) + num);
                map.put(digitSum, Math.max(map.get(digitSum), num));
            } else {
                map.put(digitSum, num);
            }
        }
        return max;
    }

    

    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {51, 71, 17, 42};
        int result = maxSum(nums);
        System.out.println("Max sum of a pair with equal digit sum: " + result);
    }
}
