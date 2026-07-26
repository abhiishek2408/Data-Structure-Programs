// ReverseEvenPositioned.java
// Reverses the elements at even positions (0-based index) in the array
/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}
Even positions: 0, 2, 4, 6 (values: 1, 3, 5, 7)
After reverse: 7, 2, 5, 4, 3, 6, 1
Output: 7 2 5 4 3 6 1
*/

class ReverseEvenPositioned {

    // Reverse the elements at even positions in the array
    static void reverseEvenPositioned(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = (n % 2 == 0) ? n - 2 : n - 1;
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
        reverseEvenPositioned(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
