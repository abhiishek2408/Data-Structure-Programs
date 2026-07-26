
// CheckIfReversed.java
// Checks if the array is sorted in strictly decreasing order (reversed)
/*
Test case:
Input: arr = {5, 4, 3, 2, 1}
Output: true
Input: arr = {5, 3, 4, 2, 1}
Output: false
*/

class CheckIfReversed {
    // Returns true if array is sorted in strictly decreasing order
    static boolean isReversed(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) return false;
        }
        return true;
    }

        // Returns true if arr2 is the reverse of arr1
    static boolean isReverseOf(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[n - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {5, 3, 4, 2, 1};
        System.out.println(isReversed(arr1)); // true
        System.out.println(isReversed(arr2)); // false

        int[] a = {3, 5, 2, 1, 4};
        int[] b = {4, 1, 2, 5, 3};
        int[] c = {4, 1, 2, 5, 2};
        System.out.println(isReverseOf(a, b)); // true
        System.out.println(isReverseOf(a, c)); // false
    }
}
