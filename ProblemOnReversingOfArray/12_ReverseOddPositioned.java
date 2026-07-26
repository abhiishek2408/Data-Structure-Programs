// ReverseOddPositioned.java
// Reverses the elements at odd positions (0-based index) in the array
/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}
Odd positions: 1, 3, 5 (values: 2, 4, 6)
After reverse: 1, 6, 3, 4, 5, 2, 7
Output: 1 6 3 4 5 2 7
*/

class ReverseOddPositioned {

    // Reverse the elements at odd positions in the array
    static void reverseOddPositioned(int[] arr) {
        int n = arr.length;
        int left = 1;
        int right = (n % 2 == 0) ? n - 1 : n - 2;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 2;
            right -= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reverseOddPositioned(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
