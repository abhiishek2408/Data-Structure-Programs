package Searching;
import java.util.*;

public class Exclude_Two_Largest {

    public long[] findElements(long arr[]) {
        int n = arr.length;
        if (n <= 2) return new long[0]; // If fewer than two elements, return empty array

        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE;
        int firstMaxIndex = -1, secondMaxIndex = -1;

        // Step 1: Find the largest and second largest elements
        for (int i = 0; i < n; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                secondMaxIndex = firstMaxIndex;
                firstMax = arr[i];
                firstMaxIndex = i;
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
                secondMaxIndex = i;
            }
        }

        // Step 2: Create a new array excluding the two largest elements
        long[] result = new long[n - 2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (i != firstMaxIndex && i != secondMaxIndex) {
                result[index++] = arr[i];
            }
        }

        // Step 3: Sort the remaining elements
        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) {
        Exclude_Two_Largest solution = new Exclude_Two_Largest();
        
        long[] arr1 = {10, 20, 5, 8, 30};
        System.out.println(Arrays.toString(solution.findElements(arr1))); // Expected: [5, 8, 10]

        long[] arr2 = {5, 5, 5, 5};
        System.out.println(Arrays.toString(solution.findElements(arr2))); // Expected: [5, 5]

        long[] arr3 = {1}; 
        System.out.println(Arrays.toString(solution.findElements(arr3))); // Expected: []

        long[] arr4 = {-10, -20, -5, -8, -30}; 
        System.out.println(Arrays.toString(solution.findElements(arr4))); // Expected: [-30, -20, -10]
    }
}


