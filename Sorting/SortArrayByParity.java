package Sorting;


public class SortArrayByParity {
    // Function to sort array by parity: all even numbers first, then odd numbers
    public static void sortByParity(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 == 0 && left < right  ) {
                left++;
            }
            while ( arr[right] % 2 != 0 && left < right) {
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
        int[] arr = {3, 1, 2, 4, 7, 6, 5, 8};
        System.out.println("Original array:");
        printArray(arr);
        sortByParity(arr);
        System.out.println("Array after sorting by parity (even first, odd last):");
        printArray(arr);
    }
}
