package Sorting;

public class SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Loop through each element in the array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the current index is the minimum
            
            // Find the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Swap the minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

 
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}


/*
CaseBest Case (Already Sorted)  O(n2)
Average Case   O(n2)
Worst Case (Reverse Sorted) O(n2)

Selection Sort always runs in O(n²) time, even if the array is already sorted.
It makes (n-1) + (n-2) + ... + 1 = O(n²) comparisons.

Space Complexity:
O(1) (Constant Space)
Since Selection Sort sorts the array in place, it does not require extra space.

Advantages of Selection Sort
✅ Simple and easy to implement
✅ Does not require extra memory (In-place sorting)
✅ Performs well on small datasets

Disadvantages of Selection Sort
❌ Inefficient for large datasets due to O(n2) complexity
❌ Not stable (relative order of equal elements may change)
*/