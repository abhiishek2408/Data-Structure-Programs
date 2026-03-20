 

import java.util.*;

public class MaxSubarraySumK {

    public static int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            if(prefixSum == k)
                maxLen = i + 1;

            if(map.containsKey(prefixSum - k)) {

                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(prefixSum))
                map.put(prefixSum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int nums[] = {1,-1,5,-2,3};
        int k = 3;

        System.out.println(maxSubArrayLen(nums, k));
    }
}
