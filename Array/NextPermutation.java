package Array;
import java.util.*;

class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: find pivot
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: find just bigger element
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: reverse right part
        reverse(nums, i + 1, n - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = {1, 2, 3};
        np.nextPermutation(nums);
        System.out.println("Next Permutation: " + Arrays.toString(nums));
    }
}

//explanation:
// This code defines a class NextPermutation that contains a method to compute the next lexicographical permutation of an array of integers.
// the algorithm works by first identifying the rightmost pair of consecutive elements where the left element is smaller than the right.
// for example, in the array [1, 2, 3, 7, 8, 5], it identifies the pair (7, 8).
// It then finds the smallest element to the right of this pair that is larger than the identified left element, 
// for example, 8 in this case,
// swaps them, and finally reverses the order of elements to the right of the original position of the left element to get the next permutation.
// for example, the next permutation of [1, 2, 3, 7, 8, 5] would be [1, 2, 3, 8, 5, 7].

// Step 1: Right se pehla chhota element dhoondo jise pivot kehte hain
//Step 2: Right side me pivot se just bada element dhoondo
// Step 3: Dono ko swap karo
// Step 4: Pivot ke baad ka hissa reverse karo

//dry run:
// Consider the input array [1, 2, 3, 7, 8, 5].
// 1. Start from the end and find the first decreasing element:
//    - i starts at index 4 (value 8), moves to index 3 (value 7) since 7 < 8, stops at index 2 (value 3) since 3 < 7.
// 2. Now, find the smallest element to the right of index 2 that is larger than nums[2] (which is 3):
//    - j starts at index 5 (value 5), which is larger than 3.
// 3. Swap elements at indices 2 and 5:
//    - Array becomes [1, 2, 5, 7, 8, 3].
// 4. Finally, reverse the elements to the right of index 2:
//    - Reverse the subarray [7, 8, 3] to get [3, 8, 7].
//    - Final array is [1, 2, 5, 3, 8, 7], which is the next permutation.

// arr1 = [1, 2, 3]
// nextPermutation(arr1) -> [1, 3, 2]
// arr2 = [3, 2, 1]
// nextPermutation(arr2) -> [1, 2, 3]