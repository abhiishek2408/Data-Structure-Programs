// ReverseInGroups.java
// Reverses the array in groups of size K

/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}, K = 3
Step 1: Reverse first 3: {3, 2, 1, 4, 5, 6, 7}
Step 2: Reverse next 3: {3, 2, 1, 6, 5, 4, 7}
Step 3: Last group (only one element): {3, 2, 1, 6, 5, 4, 7}
Output: 3 2 1 6 5 4 7
*/

class ReverseInGroups {

    // Reverse elements in the array from index l to r
    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    // Reverse the array in groups of size K
    static void reverseInGroups(int[] arr, int K) {
        int n = arr.length;
        for (int i = 0; i < n; i += K) {
            int left = i;
            int right = Math.min(i + K - 1, n - 1);
            reverse(arr, left, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseInGroups(arr, 3);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
