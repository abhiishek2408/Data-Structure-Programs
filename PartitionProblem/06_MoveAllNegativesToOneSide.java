package PartitionProblem;


public class MoveAllNegativesToOneSide {
    // Function to move all negative numbers to one side of the array
    public static void moveNegatives(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            if (arr[left] < 0) {
                left++;
            } else if (arr[right] >= 0) {
                right--;
            } else {
                // Swap arr[left] and arr[right]
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
        int[] arr = {1, -2, 3, -4, -5, 6, -7, 8};
        System.out.println("Original array:");
        printArray(arr);
        moveNegatives(arr);
        System.out.println("Array after moving negatives to one side:");
        printArray(arr);
    }
}
