package Sorting;

import java.util.Arrays;

public class SelectionSortStrings {
    public static void selectionSort(String[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) { // Compare strings
                    minIndex = j;
                }
            }

            // Swap
            String temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"banana", "apple", "cherry", "mango", "grape"};

        System.out.println("Original array: " + Arrays.toString(arr));

        selectionSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
