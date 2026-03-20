package Array;

// RemoveDuplicatesTwoPointers.java
// Implementation of removeDuplicates using two pointers (left, right)

public class RemoveDuplicatesTwoPointers {
    /**
     * Removes duplicates from a sorted array in-place using two pointers.
     * @param nums Sorted input array
     * @return The length of the array after removing duplicates
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    // Example usage
    public static void main(String[] args) {
        RemoveDuplicatesTwoPointers solution = new RemoveDuplicatesTwoPointers();
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int len = solution.removeDuplicates(nums);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nNew length: " + len);
    }
}
