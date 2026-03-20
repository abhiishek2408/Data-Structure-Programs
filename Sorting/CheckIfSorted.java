package Sorting;

// CheckIfSorted.java
// Checks if the array is sorted in non-decreasing order
/*
Test case:
Input: arr = {1, 2, 3, 4, 5}
Output: true
Input: arr = {1, 3, 2, 4, 5}
Output: false
*/

class CheckIfSorted {
    // Returns true if array is sorted in non-decreasing order
    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 2, 4, 5};
        System.out.println(isSorted(arr1)); // true
        System.out.println(isSorted(arr2)); // false
    }
}
