// ReverseExceptFirstLast.java
// Reverses the array except the first and last element
/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}
Reverse elements from index 1 to 5: {1, 6, 5, 4, 3, 2, 7}
Output: 1 6 5 4 3 2 7
*/

class ReverseExceptFirstLast {

    // Reverse the array except the first and last element
    static void reverseExceptFirstLast(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
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
        reverseExceptFirstLast(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
