import java.util.*;

public class LengthOfCompleteSubArray {
    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> uniqueElements = new HashSet<>();
        
        // Find the number of unique elements in nums
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int requiredUniqueCount = uniqueElements.size();
        int count = 0;

        // Sliding Window Approach
        for (int left = 0; left < n; left++) {
            Set<Integer> windowSet = new HashSet<>();
            for (int right = left; right < n; right++) {
                windowSet.add(nums[right]);
                if (windowSet.size() == requiredUniqueCount) {
                    count++;  // Found a complete subarray
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Length of Complete SubArray: ");
        System.out.println(countCompleteSubarrays(new int[]{1,3,1,2,3}));
    }
}


