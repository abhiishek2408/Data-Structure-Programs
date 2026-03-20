package Array;

// MoveZeroesTwoPointers.java
// Implementation of moveZeroes using two pointers (left, right)

public class MoveZeroesTwoPointers {
    /**
     * Moves all zeroes in the array to the end while maintaining the order of non-zero elements.
     * @param nums Input array
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                swap(nums, left, right);   // Swap non-zero element to the 'left' position
                left++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Example usage
    public static void main(String[] args) {
        MoveZeroesTwoPointers solution = new MoveZeroesTwoPointers();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.print("Array after moving zeroes: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
