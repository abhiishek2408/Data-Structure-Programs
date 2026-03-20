package SlidingWindow;

import java.util.HashMap;

public class CountSubarraySumK {

    public static int countSubarraysNaive(int[] nums, int k) {

    int count = 0;

    for(int i = 0; i < nums.length; i++) {
        int sum = 0;
        
        for(int j = i; j < nums.length; j++) {
            sum += nums[j];

            if(sum == k)
                count++;
        }
    }

    return count;
}

    public static int countSubarrays(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        map.put(0, 1);

        for(int num : nums) {
            prefixSum += num;

            if(map.containsKey(prefixSum - k))
            count += map.get(prefixSum - k);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int nums[] = {1,1,1};
        int k = 2;

        System.out.println(countSubarrays(nums, k));
    }
}
