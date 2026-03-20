// ReverseAfterIndex.java
// Reverses the array from a given index+1 to the end
/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}, idx = 3
Reverse elements from index 4 to 6: {1, 2, 3, 4, 7, 6, 5}
Output: 1 2 3 4 7 6 5
*/

class ReverseAfterIndex {

    // Reverse the array from index idx+1 to the end
    static void reverseAfterIndex(int[] arr, int idx) {
        int left = idx + 1;
        int right = arr.length - 1;
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
        reverseAfterIndex(arr, 3);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
