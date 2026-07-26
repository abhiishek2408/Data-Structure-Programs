package PartitionProblem;

public class SegregateEvenOdd {
    // Function to segregate even and odd numbers in the array
    public static void segregateEvenOdd(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }
            while (arr[right] % 2 == 1 && left < right) {
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
        int[] arr = {12, 17, 70, 15, 22, 65, 21, 90};
        System.out.println("Original array:");
        printArray(arr);
        segregateEvenOdd(arr);
        System.out.println("Array after segregating even and odd numbers:");
        printArray(arr);
    }
}
