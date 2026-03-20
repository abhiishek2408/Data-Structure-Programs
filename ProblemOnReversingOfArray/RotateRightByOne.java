// RotateRightByOne.java
// Rotates a subarray to the right by one position from index L to R

class RotateRightByOne {

    // Rotates the subarray arr[L..R] to the right by one position
    static void rotateRightByOne(int[] arr, int L, int R) {
        int temp = arr[R];
        for (int i = R; i > L; i--) {
            arr[i] = arr[i - 1];
        }
        arr[L] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateRightByOne(arr, 2, 5);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
