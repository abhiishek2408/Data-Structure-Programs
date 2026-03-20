// ReverseUntilIndex.java
// Reverses the array from index 0 to a given index (inclusive)
/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}, idx = 4
Reverse elements from index 0 to 4: {5, 4, 3, 2, 1, 6, 7}
Output: 5 4 3 2 1 6 7
*/

class ReverseUntilIndex {

    // Reverse the array from index 0 to idx (inclusive)
    static void reverseUntilIndex(int[] arr, int idx) {
        int left = 0;
        int right = idx;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reverseUntilIndex(arr, 4);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
