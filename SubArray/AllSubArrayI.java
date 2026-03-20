import java.util.*;


    public class AllSubArrayI {
    public static void printAllSubarrays(int[] nums) {
        int n = nums.length;

        // Generate all subarrays
        for (int start = 0; start < n; start++) {
            List<Integer> subArray = new ArrayList<>();
            for (int end = start; end < n; end++) {
                subArray.add(nums[end]);  // Add the current element to subarray
                System.out.println(subArray); // Print the subarray
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("All Subarrays:");
        printAllSubarrays(nums);
    }
}

