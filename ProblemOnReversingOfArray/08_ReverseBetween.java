// ReverseBetween.java
// Reverses the elements of an array between indices L and R (inclusive)

class ReverseBetween {

    // Reverse elements in the array from index L to R
    static void reverseBetween(int[] arr, int L, int R) {
        while (L < R) {
            int temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
            L++;
            R--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reverseBetween(arr, 2, 5);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
