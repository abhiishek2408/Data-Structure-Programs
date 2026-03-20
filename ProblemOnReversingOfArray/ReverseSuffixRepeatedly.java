// ReverseSuffixRepeatedly.java
// Repeatedly reverses the suffix of the array for a given list of indices
/*
Test case:
Input: arr = {1, 2, 3, 4, 5}, indices = {2, 3}
Step 1: Reverse suffix from 2: {1, 2, 5, 4, 3}
Step 2: Reverse suffix from 3: {1, 2, 5, 3, 4}
Output: 1 2 5 3 4
*/

import java.util.Arrays;

class ReverseSuffixRepeatedly {
    // Reverse suffix of arr from index idx (inclusive) to end
    static void reverseSuffix(int[] arr, int idx) {
        int left = idx, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Repeatedly reverse suffixes for each index in indices
    static void reverseSuffixes(int[] arr, int[] indices) {
        for (int idx : indices) {
            if (idx >= 0 && idx < arr.length) {
                reverseSuffix(arr, idx);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] indices = {2, 3};
        reverseSuffixes(arr, indices);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 4, 3] after first, [1, 2, 5, 3, 4] after second
    }
}
