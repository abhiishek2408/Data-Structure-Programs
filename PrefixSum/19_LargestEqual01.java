 

import java.util.*;

public class LargestEqual01 {

    public static int findMaxLength(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,-1);

        int prefix = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] == 0)
                prefix += -1;
            else
                prefix += 1;

            if(map.containsKey(prefix)) {

                int len = i - map.get(prefix);
                maxLen = Math.max(maxLen,len);
            }
            else {
                map.put(prefix,i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int nums[] = {0,1,0,1,1,1,0};

        System.out.println(findMaxLength(nums));
    }
}
