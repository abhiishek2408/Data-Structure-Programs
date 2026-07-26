package Array;

import java.util.*;

public class _65_MaxFrequencyElements {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //[1,2,2,3,1,4] 
        // Step 1: count frequency
        for (int num : nums) {  // {1=2, 2=2, 3=1, 4=1}
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        // map.values() -> [2,2,1,1] 
        // Step 2: find maximum frequency
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int ans = 0;

        // Step 3: sum frequencies equal to maxFreq
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                ans += freq;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        _65_MaxFrequencyElements solution = new _65_MaxFrequencyElements();
        int[] nums = {1, 2, 2, 3, 3, 3};
        int result = solution.maxFrequencyElements(nums);
        System.out.println("Sum of elements with maximum frequency: " + result);
    }
}
