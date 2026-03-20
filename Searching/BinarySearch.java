package Searching;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Found
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50}; // Sorted array
        int target = 30;
        int index = binarySearch(arr, target);
        System.out.println("Element found at index: " + index);
    }
}

/*
Binary Search (For Sorted Arrays)
Definition:
Binary Search is an efficient search algorithm that works on sorted arrays by repeatedly dividing the search interval in half.

Algorithm:
Find the middle element.

If the middle element is the target, return its index.

If the target is smaller, search in the left half.

If the target is larger, search in the right half.

Repeat until the target is found or the search space is empty.

Best Case	O(1) (Middle element is the target)
Average Case O(logn)
Worst Case O(logn)

Space Complexity:O(1) (Iterative version)
O(logn) (Recursive version due to function call stack) 



*/