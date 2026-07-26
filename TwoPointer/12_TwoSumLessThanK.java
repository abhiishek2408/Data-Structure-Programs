package TwoPointer;

import java.util.Arrays;

public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxSum = -1;

        while(left < right) {

            int sum = nums[left] + nums[right];

            if(sum < k) {
                maxSum = Math.max(maxSum, sum);
                left++;
            }
            else {
                right--;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int nums[] = {34,23,1,24,75,33,54,8};
        int k = 60;

        System.out.println(twoSumLessThanK(nums, k));
    }
}
