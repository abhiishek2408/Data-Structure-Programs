import java.util.Arrays;

class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return; // No change needed for single-element array
        }

        int idx1 = -1;
        // Step 1: Find the first index from the end where nums[i] < nums[i + 1]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx1 = i;
                break;
            }
        }

        if (idx1 < 0) {
            // If no such index is found, reverse the entire array
            reverse(nums, 0, nums.length - 1);
        } 
        else {
            // Step 2: Find the smallest number greater than nums[idx1] to its right
            int idx2 = 0;
            for (int i = nums.length - 1; i > idx1; i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }

            // Step 3: Swap nums[idx1] and nums[idx2]
            swap(nums, idx1, idx2);

            // Step 4: Sort the array from idx1 + 1 to the end
            Arrays.sort(nums, idx1 + 1, nums.length);
        }
    }

    // Helper method to reverse part of the array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Example usage
    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = {1, 6, 3, 7, 9};
        System.out.println(nums[nums.length-1]);
        System.out.println(nums[nums.length-2]);
        System.out.println(nums[nums.length-3]);
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 3, 2]
    }
}

// 5 3 4 9 7 6
// 5 3 6 4 7 9 