 

import java.util.*;

//Given an integer array nums and an integer k, return true if the array has a 
// continuous subarray of size ≥ 2 whose sum is a multiple of k.
//Store remainder of prefixSum % k in a HashMap.
//If the same remainder appears again and the distance ≥ 2, we found a valid subarray.
//Repeat remainder means: difference divisible by k

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int prefix = 0;

        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            int remainder = prefix % k;
            if(map.containsKey(remainder)) {
                if(i - map.get(remainder) >= 2)
                    return true;
            }
            else {
                map.put(remainder,i);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int nums[] = {23,2,4,6,7};
        int k = 6;

        System.out.println(checkSubarraySum(nums,k));
    }
}
