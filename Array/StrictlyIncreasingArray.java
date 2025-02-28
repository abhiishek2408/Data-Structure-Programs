class StrictlyIncreasingArray {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0; // To track the number of elements removed
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) { 
                count++; // Found a problem, need to remove an element

                // If more than one removal is needed, return false
                if (count > 1) return false;

                // Check if removing nums[i-1] or nums[i] can maintain strict increasing order
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    nums[i] = nums[i - 1]; // Modify nums[i] to keep order
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        StrictlyIncreasingArray solution = new StrictlyIncreasingArray();

        int[] nums1 = {1, 2, 10, 5, 7};
        System.out.println(solution.canBeIncreasing(nums1)); // Output: true

        int[] nums2 = {2, 3, 1, 2};
        System.out.println(solution.canBeIncreasing(nums2)); // Output: false

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(solution.canBeIncreasing(nums3)); // Output: true

        int[] nums4 = {10, 1, 2, 3};
        System.out.println(solution.canBeIncreasing(nums4)); // Output: true
    }
}
