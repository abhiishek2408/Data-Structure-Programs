 

import java.util.*;

public class CountEqual01 {

    public static int countSubarrays(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int prefix = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 0)
                prefix += -1;
            else
                prefix += 1;

            if(map.containsKey(prefix))
                count += map.get(prefix);

            map.put(prefix, map.getOrDefault(prefix,0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int nums[] = {0,1,0,1};

        System.out.println(countSubarrays(nums));
    }
}
