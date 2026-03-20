package Collection.ArrayList;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store each number and its latest index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number is already in the map
            if (map.containsKey(nums[i])) {
                // If it is, check the difference between the current index and the stored index
                if (i - map.get(nums[i]) <= k) {
                    // If the difference is less than or equal to k, return true
                    return true;
                }
            }
            // Update the map with the current index of the number
            map.put(nums[i], i);
        }
        
        // If no duplicates found within the range, return false
        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate solution = new ContainDuplicate();
        
        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(solution.containsNearbyDuplicate(nums1, k1)); // Output: true
        
        // Test case 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(solution.containsNearbyDuplicate(nums2, k2)); // Output: true
        
        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        System.out.println(solution.containsNearbyDuplicate(nums3, k3)); // Output: false
    }
}

