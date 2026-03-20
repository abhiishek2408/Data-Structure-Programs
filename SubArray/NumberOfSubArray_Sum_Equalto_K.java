//Variable Window Problem

import java.util.HashMap;

public class NumberOfSubArray_Sum_Equalto_K {
        public static int subarraySum(int[] arr, int k) {
                
                int ans = 0;
                int prefixSum = 0;
        
                HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        
                prefixSumCount.put(0, 1);
            
                for (int i=0;i<arr.length;i++) {
                    prefixSum += arr[i];
        
                    if (prefixSumCount.containsKey(prefixSum - k)) {
                        ans += prefixSumCount.get(prefixSum - k);
                    }
        
                    prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
                }
                        
                return ans; 
            }
        
            public static void main(String[] args) {
                int[] nums = {1, 1, 1};
                int k = 6;
                System.out.println(subarraySum(nums, k)); // Output should be 2
    }
}
