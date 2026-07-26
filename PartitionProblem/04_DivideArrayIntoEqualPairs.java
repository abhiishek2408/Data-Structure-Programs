package PartitionProblem;

public class DivideArrayIntoEqualPairs {
    // Returns true if nums can be partitioned into pairs of equal elements
    public static boolean canDivideIntoPairs(int[] nums) {
        int[] freq = new int[501]; // constraints bound nums[i]
        for (int num : nums) {
            freq[num]++;
        }
        for (int count : freq) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3, 2, 2, 2};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(canDivideIntoPairs(nums1)); // true
        System.out.println(canDivideIntoPairs(nums2)); // false
    }
}
