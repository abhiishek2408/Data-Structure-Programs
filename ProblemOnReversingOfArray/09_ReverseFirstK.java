// ReverseFirstK.java
// Reverses the first K elements of an array

class ReverseFirstK {

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

    // Reverse the first K elements of the array
    static void reverseFirstK(int[] arr, int K) {
        if (K > 0 && K <= arr.length) {
            reverse(arr, 0, K - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reverseFirstK(arr, 4);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
