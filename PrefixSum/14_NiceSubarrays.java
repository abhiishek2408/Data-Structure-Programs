 

import java.util.*;

public class NiceSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefix = 0;
        int count = 0;

        for(int num : nums) {

            prefix += num % 2;

            if(map.containsKey(prefix - k))
                count += map.get(prefix - k);

            map.put(prefix, map.getOrDefault(prefix,0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int nums[] = {1,1,2,1,1};
        int k = 3;

        System.out.println(numberOfSubarrays(nums,k));
    }
}
