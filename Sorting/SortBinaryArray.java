package Sorting;

public class SortBinaryArray {
    // Function to sort a binary array (0s and 1s) using two pointers
    public static void sortBinaryArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (arr[left] == 0 && left < right) {
                left++;
            }
            while (arr[right] == 1 && left < right) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    // Utility function to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 0, 1, 0};
        System.out.println("Original binary array:");
        printArray(arr);
        sortBinaryArray(arr);
        System.out.println("Sorted binary array:");
        printArray(arr);
    }
}
