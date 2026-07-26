 

import java.util.*;

public class CountSubarraysSumK {

    public static int countSubarrays(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int prefix = 0;
        int count = 0;

        for(int num : nums) {

            prefix += num;

            if(map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }

            map.put(prefix, map.getOrDefault(prefix,0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int nums[] = {1,2,3};
        int k = 3;

        System.out.println(countSubarrays(nums,k));
    }
}
