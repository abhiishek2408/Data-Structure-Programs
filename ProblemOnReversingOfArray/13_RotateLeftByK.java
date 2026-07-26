// RotateLeft.java
// Rotates an array to the left by k positions using reversal algorithm

class RotateLeftByK {

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

    // Rotate the array to the left by k positions
    static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, k - 1);     // Reverse first k elements
        reverse(arr, k, n - 1);     // Reverse last n-k elements
        reverse(arr, 0, n - 1);     // Reverse the whole array
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotateLeft(arr, 2);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
