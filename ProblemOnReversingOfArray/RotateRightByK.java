// RotateRight.java
// Rotates an array to the right by k positions using reversal algorithm

class RotateRightByK {

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

    // Rotate the array to the right by k positions
    static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, n - k, n - 1); // Reverse last k elements
        reverse(arr, 0, n - k - 1); // Reverse first n-k elements
        reverse(arr, 0, n - 1);     // Reverse the whole array
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotateRight(arr, 2);

        for (int x : arr)
            System.out.print(x + " ");
    }
}


/*Steps:

1️⃣ Reverse last K elements
2️⃣ Reverse first (n-K) elements
3️⃣ Reverse whole array 

*/