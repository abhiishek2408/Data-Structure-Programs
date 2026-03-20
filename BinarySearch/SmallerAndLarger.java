package BinarySearch;

import java.util.*;

class SmallerAndLarger { // Renamed class for clarity
    int[] getMoreAndLess(int[] arr, int target) {
        int n = arr.length;
        int lessOrEqualCount = upperBound(arr, target); // Elements ≤ target
        int greaterOrEqualCount = n - lowerBound(arr, target); // Elements ≥ target
        
        return new int[]{lessOrEqualCount, greaterOrEqualCount};
    }
    
    // Returns index of first element greater than target (Upper Bound)
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1; 
            } else {
                high = mid;
            }
        }
        return low; // Number of elements ≤ target
    }
    
    // Returns index of first element ≥ target (Lower Bound)
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // Number of elements before first element ≥ target
    }

    public static void main(String[] args) {
        SmallerAndLarger solution = new SmallerAndLarger(); // Using new class name
        
        int[] arr1 = {1, 2, 8, 10, 11, 12, 19};
        System.out.println(Arrays.toString(solution.getMoreAndLess(arr1, 0))); // Expected: [0, 7]

        int[] arr2 = {1, 5, 8, 12, 12, 12, 19};
        System.out.println(Arrays.toString(solution.getMoreAndLess(arr2, 12))); // Expected: [6, 4]

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution.getMoreAndLess(arr3, 3))); // Expected: [3, 3]
    }
}
