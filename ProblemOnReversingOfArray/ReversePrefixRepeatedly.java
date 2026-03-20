// ReversePrefixRepeatedly.java
// Repeatedly reverses the prefix of the array for a given list of indices
/*
Test case:
Input: arr = {1, 2, 3, 4, 5}, indices = {3, 4}
Step 1: Reverse prefix up to 3: {3, 2, 1, 4, 5}
Step 2: Reverse prefix up to 4: {4, 1, 2, 3, 5}
Output: 4 1 2 3 5
*/

import java.util.Arrays;

class ReversePrefixRepeatedly {
    // Reverse prefix of arr up to index idx (inclusive)
    static void reversePrefix(int[] arr, int idx) {
        int left = 0, right = idx;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Repeatedly reverse prefixes for each index in indices
    static void reversePrefixes(int[] arr, int[] indices) {
        for (int idx : indices) {
            if (idx >= 0 && idx < arr.length) {
                reversePrefix(arr, idx);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] indices = {2, 3};
        reversePrefixes(arr, indices);
        System.out.println(Arrays.toString(arr)); // [3, 2, 1, 4, 5] after first, [4, 1, 2, 3, 5] after second
    }
}
