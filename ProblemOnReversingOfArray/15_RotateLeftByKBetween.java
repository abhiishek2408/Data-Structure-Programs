// RotateLeftBetween.java
// Rotates a subarray arr[L..R] to the left by K positions using reversal algorithm

class RotateLeftByKBetween {

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

    // Rotate the subarray arr[L..R] to the left by K positions
    static void rotateLeftBetween(int[] arr, int L, int R, int K) {
        int len = R - L + 1;
        K = K % len;

        reverse(arr, L, L + K - 1);   // Reverse first K elements in subarray
        reverse(arr, L + K, R);       // Reverse remaining elements in subarray
        reverse(arr, L, R);           // Reverse the whole subarray
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateLeftBetween(arr, 2, 5, 2);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
