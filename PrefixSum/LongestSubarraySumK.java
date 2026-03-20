 

import java.util.*;

public class LongestSubarraySumK {

    public static int longestSubarray(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int prefix = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            if(prefix == k)
                maxLen = i + 1;

            if(map.containsKey(prefix - k)) {

                int len = i - map.get(prefix - k);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(prefix))
                map.put(prefix, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int nums[] = {10,5,2,7,1,9};
        int k = 15;

        System.out.println(longestSubarray(nums,k));
    }
}
