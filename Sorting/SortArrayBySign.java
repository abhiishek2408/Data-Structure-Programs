package Sorting;

public class SortArrayBySign {
    // Function to sort array by sign: all positive numbers first, then negative numbers
    public static void sortBySign(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while ( arr[left] >= 0 && left < right) {
                left++;
            }
            while ( arr[right] < 0 && left < right) {
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
        int[] arr = {-1, 2, -3, 4, -5, 6, 7, -8};
        System.out.println("Original array:");
        printArray(arr);
        sortBySign(arr);
        System.out.println("Array after sorting by sign (positive first, negative last):");
        printArray(arr);
    }
}
