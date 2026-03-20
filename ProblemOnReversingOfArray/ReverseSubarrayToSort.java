// ReverseSubarrayToSort.java
// Finds the minimum subarray to reverse to sort the array
/*
Test case:
Input: arr = {1, 2, 6, 5, 4, 3, 7, 8}
Reverse subarray from index 2 to 5: {1, 2, 3, 4, 5, 6, 7, 8}
Output: Reverse from 2 to 5
*/

class ReverseSubarrayToSort {

    // Returns the indices of the subarray to reverse to sort the array, or -1 if not possible
    static int[] findSubarrayToReverse(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;

        while (l < n - 1 && arr[l] <= arr[l + 1]) l++; // Find the first index where order breaks from left
        if (l == n - 1) return new int[]{-1, -1}; // Already sorted
        while (r > 0 && arr[r] >= arr[r - 1]) r--; // Find the first index where order breaks from right
        // Reverse the subarray arr[l..r]
        int left = l, right = r;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        // Check if array is sorted after reversal
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) return new int[]{-1, -1};
        }
        return new int[]{l, r};
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 5, 4, 3, 7, 8};
        int[] result = findSubarrayToReverse(arr);
        if (result[0] == -1) {
            System.out.println("Array cannot be sorted by one reversal");
        } else {
            System.out.println("Reverse from " + result[0] + " to " + result[1]);
        }
    }
}
