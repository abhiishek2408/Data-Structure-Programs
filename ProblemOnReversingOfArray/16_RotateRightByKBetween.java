// RotateRightByKBetween.java
// Rotates a subarray arr[L..R] to the right by K positions using reversal algorithm

class RotateRightByKBetween {

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

    // Rotate the subarray arr[L..R] to the right by K positions
    static void rotateRightBetween(int[] arr, int L, int R, int K) {
        int len = R - L + 1;
        K = K % len;

        reverse(arr, R - K + 1, R);   // Reverse last K elements in subarray
        reverse(arr, L, R - K);       // Reverse first len-K elements in subarray
        reverse(arr, L, R);           // Reverse the whole subarray
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateRightBetween(arr, 2, 5, 2);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
