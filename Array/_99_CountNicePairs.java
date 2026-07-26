package Array;

import java.util.*;

public class _99_CountNicePairs {
    public int countNicePairs(int[] nums) {
        final int MOD = 1_000_000_007;
        Map<Integer, Integer> countMap = new HashMap<>();
        long res = 0;
        
        for (int num : nums) {
            int key = num - rev(num);
            res = (res + countMap.getOrDefault(key, 0)) % MOD;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        
        return (int) res;
    }
    
    private int rev(int num) {
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num /= 10;
        }
        return revNum;
    }

    public static void main(String[] args) {
        _99_CountNicePairs solution = new _99_CountNicePairs();
        int[] nums = {42, 11, 1, 97};
        int result = solution.countNicePairs(nums);
        System.out.println("Number of nice pairs: " + result);
    }
}
