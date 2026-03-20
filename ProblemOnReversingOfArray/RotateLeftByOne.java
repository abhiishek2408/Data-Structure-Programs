// RotateLeftByOne.java
// Rotates a subarray to the left by one position from index L to R

/*arr = [1, 2, 3, 4, 5, 6, 7]
L = 2
R = 5

index 2 to 5 → [3, 4, 5, 6]

[1, 2, 4, 5, 6, 3, 7]

 */

class RotateLeftByOne {

    // Rotates the subarray arr[L..R] to the left by one position
    static void rotateLeftByOne(int[] arr, int L, int R) {
        int temp = arr[L];
        for (int i = L; i < R; i++) {
            arr[i] = arr[i + 1];
        }
        arr[R] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateLeftByOne(arr, 2, 5);

        for (int x : arr)
            System.out.print(x + " ");
    }
}
