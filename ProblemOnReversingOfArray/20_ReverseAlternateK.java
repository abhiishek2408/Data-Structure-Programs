// ReverseAlternateK.java
// Reverses alternate groups of K elements in the array
/*
Test case:
Input: arr = {1, 2, 3, 4, 5, 6, 7}, K = 2
Step 1: Reverse first 2: {2, 1, 3, 4, 5, 6, 7}
Step 2: Skip next 2: {2, 1, 3, 4, 5, 6, 7}
Step 3: Reverse next 2: {2, 1, 3, 4, 7, 6, 5}
Output: 2 1 3 4 7 6 5
*/

class ReverseAlternateK {

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

    // Reverse alternate groups of K elements in the array
    static void reverseAlternateK(int[] arr, int K) {
        int n = arr.length;
        boolean reverseFlag = true;
        for (int i = 0; i < n; i += K) {
            if (reverseFlag) {
                int left = i;
                int right = Math.min(i + K - 1, n - 1);
                reverse(arr, left, right);
            }
            reverseFlag = !reverseFlag;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reverseAlternateK(arr, 2);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
