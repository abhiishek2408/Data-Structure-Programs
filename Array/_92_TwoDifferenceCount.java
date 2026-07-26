package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _92_TwoDifferenceCount {
    public int countPairsWithDifference(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for (int num : nums) {
            if (set.contains(num + k)) count++;
            if (set.contains(num - k)) count++;
            
            set.add(num);
        }
        
        return count;
    }


    public int countPairsWithDifferenceSorted(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int count = 0;
        
        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            
            if (diff == k) {
                count++;
                left++;
                right++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
                if (left == right) right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _92_TwoDifferenceCount solution = new _92_TwoDifferenceCount();
        int[] nums = {1, 5, 3, 4, 2};
        int k = 2;

        int result = solution.countPairsWithDifference(nums, k);
        System.out.println("Count of pairs with difference " + k + ": " + result);
    }
}
