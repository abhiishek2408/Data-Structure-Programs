// CircularRotationReverse.java
// Performs circular rotation (right and left) of the array by K positions using the reverse technique
/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}, K = 3
Step 1: Reverse last 3: {1, 2, 3, 4, 7, 6, 5}
Step 2: Reverse first 4: {4, 3, 2, 1, 7, 6, 5}
Step 3: Reverse whole: {5, 6, 7, 1, 2, 3, 4}
Output: 5 6 7 1 2 3 4
*/

class CircularRotationReverse {

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

    // Perform circular rotation (right) by K positions using reverse technique
    static void circularRotateRight(int[] arr, int K) {
        int n = arr.length;
        K = K % n;
        if (K == 0) return;
        reverse(arr, n - K, n - 1);   // Reverse last K elements
        reverse(arr, 0, n - K - 1);   // Reverse first n-K elements
        reverse(arr, 0, n - 1);       // Reverse the whole array
    }

    // Perform circular rotation (left) by K positions using reverse technique
    static void circularRotateLeft(int[] arr, int K) {
        int n = arr.length;
        K = K % n;
        if (K == 0) return;
        reverse(arr, 0, K - 1);       // Reverse first K elements
        reverse(arr, K, n - 1);       // Reverse last n-K elements
        reverse(arr, 0, n - 1);       // Reverse the whole array
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        circularRotateRight(arr, 3);
        System.out.print("Right Rotation by 3: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        circularRotateLeft(arr2, 3);
        System.out.print("Left Rotation by 3: ");
        for (int x : arr2)
            System.out.print(x + " ");
        System.out.println();
    }
}
