package Array;
// Problem: Find all pairs in a sorted array with a given difference using two pointers
// Time Complexity: O(n log n) (due to sorting)
// Space Complexity: O(1) (ignoring output)

import java.util.*;

public class PairWithGivenDifferenceTwoPointer {
    // Returns a 1D array of the first elements of all pairs with given difference
   public static boolean findPair(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0, j = 1;  // forward pointers 

        while (i < nums.length && j < nums.length) {

            if (i != j && nums[j] - nums[i] == k) {
                return true;
            }
            else if (nums[j] - nums[i] < k) {
                j++;
            }
            else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int diff = 2;
        boolean result = findPair(arr, diff);
        System.out.println("Elements with a pair of difference " + diff + " (Two Pointer):");
        if (result) {
            System.out.println("Pair exists with the given difference.");
        } else {
            System.out.println("No pair exists with the given difference.");
        }
        System.out.println();
    }
}
