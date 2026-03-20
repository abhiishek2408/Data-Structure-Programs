package Sorting;

// CheckSortedAfterReverse.java
// Checks if the array becomes sorted after reversing a single subarray
/*
Test case:
Input: arr = {1, 2, 6, 5, 4, 3, 7, 8}
Output: true (reverse 2 to 5)
Input: arr = {1, 3, 2, 4, 5}
Output: true (reverse 1 to 2)
Input: arr = {1, 5, 3, 4, 2, 6}
Output: false
*/

class CheckSortedAfterReverse {

    // Returns true if array can be sorted by reversing a single subarray
    static boolean checkSortedAfterReverse(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        // Find the first index where order breaks from left
        while (l < n - 1 && arr[l] <= arr[l + 1]) l++;
        if (l == n - 1) return true; // Already sorted
        // Find the first index where order breaks from right
        while (r > 0 && arr[r] >= arr[r - 1]) r--;
        // Check if reversing arr[l..r] sorts the array
        int left = l, right = r;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 6, 5, 4, 3, 7, 8};
        int[] arr2 = {1, 3, 2, 4, 5};
        int[] arr3 = {1, 5, 3, 4, 2, 6};
        System.out.println(checkSortedAfterReverse(arr1)); // true
        System.out.println(checkSortedAfterReverse(arr2)); // true
        System.out.println(checkSortedAfterReverse(arr3)); // false
    }
}
