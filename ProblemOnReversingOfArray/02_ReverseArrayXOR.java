// ReverseArrayXOR.java
// Reverses an array in place using XOR swap
/*
Test case:
Input: arr = {1, 2, 3, 4, 5}
Output: 5 4 3 2 1
*/

import java.util.Arrays;

class ReverseArrayXOR {
    // Reverses the array using XOR swap
    static void reverseXOR(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseXOR(arr);
        System.out.println(Arrays.toString(arr)); // [5, 4, 3, 2, 1]
    }
}
