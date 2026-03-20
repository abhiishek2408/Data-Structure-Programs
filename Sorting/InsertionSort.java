package Sorting;

public class InsertionSort {
    // Method to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to be inserted
            int j = i - 1;

            // Shift elements of sorted part to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key into its correct position
            arr[j + 1] = key;
        }
    }

    // Method to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test insertion sort
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}


/*Time Complexity Analysis
Case
Best Case (Already Sorted)  O(n)
Average Case                O(n2)
Worst Case (Reverse Sorted) O(n2)
Best case happens when the array is already sorted, requiring only o(n) comparisons.
Worst case happens when the array is sorted in reverse order, requiring o(n2) swaps. 

Space Complexity
• 0(1) (Constant Space)
• Since Insertion Sort sorts the array in place, it does not require extra memory.
Advantages of Insertion Sort
Efficient for small or nearly sorted datasets
Stable Sort (maintains the relative order of equal elements)
In-place Sort (does not require extra memory)
Adaptive (performs better when the array is nearly sorted)
Disadvantages of Insertion Sort
X Inefficient for large datasets (O(n2) complexity)
x
Slower than Merge Sort and Quick Sort for large inputs



Insertion Sort in Java
Introduction
Insertion Sort is a simple and efficient comparison-based sorting algorithm that works similarly to how we sort playing cards in our hands.

It builds the sorted array one element at a time by shifting larger elements to the right.

It's efficient for small or nearly sorted datasets.

It is stable (maintains the relative order of equal elements) and in-place (requires no extra memory).

Working of Insertion Sort
Assume the first element is already sorted.

Take the next element and compare it with the previous sorted elements.

Shift larger elements to the right and insert the current element in the correct position.

Repeat until all elements are sorted.

Insertion Sort Algorithm
Start from the second element (index 1).

Compare it with the elements before it.

Shift larger elements one position to the right.

Insert the selected element in its correct position.

Repeat for all elements in the array.

*/