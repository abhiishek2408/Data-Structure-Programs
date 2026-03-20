 

import java.util.HashMap;

public class CountSubarraysDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int prefix = 0;
        int count = 0;

        for(int num : nums) {

            prefix += num;

            int remainder = prefix % k;

            if(remainder < 0)
                remainder += k;

            if(map.containsKey(remainder))
                count += map.get(remainder);

            map.put(remainder, map.getOrDefault(remainder,0)+1);
        }

        return count;
    }

    public static void main(String[] args) {

        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;

        System.out.println(subarraysDivByK(nums,k));
    }
}
