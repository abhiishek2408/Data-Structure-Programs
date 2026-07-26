package Array;

public class _41_ReverseArray {
    void reverse(int[] arr) {
       
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

    }



    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _41_ReverseArray solution = new _41_ReverseArray();
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original Array:");
        printArray(arr);

        solution.reverse(arr);

        System.out.println("Reversed Array:");
        printArray(arr);
    }
}
