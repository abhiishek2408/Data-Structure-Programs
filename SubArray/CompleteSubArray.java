import java.util.*;

public class CompleteSubArray {
    public static void printCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> uniqueElements = new HashSet<>();
        
        // Find the number of unique elements in nums
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int requiredUniqueCount = uniqueElements.size(); // Distinct elements count

        // Brute Force Approach: Generate all subarrays
        for (int left = 0; left < n; left++) {
            Set<Integer> windowSet = new HashSet<>();
            List<Integer> subArray = new ArrayList<>();
            for (int right = left; right < n; right++) {
                windowSet.add(nums[right]);
                subArray.add(nums[right]);
                
                // If the current subarray contains all unique elements, print it
                if (windowSet.size() == requiredUniqueCount) {
                    System.out.println(subArray);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 3};
        System.out.println("Complete Subarrays:");
        printCompleteSubarrays(nums);
    }
}

/*
a complete subarray is a contiguous subarray that contains all 
distinct elements of the original array at least once.


Complete Subarrays:
[1, 3, 1, 2]
[1, 3, 1, 2, 3]
[3, 1, 2, 3]
[1, 2, 3]
 */


