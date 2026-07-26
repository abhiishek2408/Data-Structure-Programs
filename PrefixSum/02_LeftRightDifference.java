 

import java.util.*;

public class LeftRightDifference {

    public static int[] leftRightDifference(int[] nums) {

        int n = nums.length;

        int totalSum = 0;

        for(int num : nums)
            totalSum += num;

        int leftSum = 0;

        int[] result = new int[n];

        for(int i = 0; i < n; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            result[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int nums[] = {10,4,8,3};

        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }
}
