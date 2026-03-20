package Array;
// IntersectionOfTwoSortedArrays.java
// Finds the intersection of two sorted arrays
// Time Complexity: O(m + n)

import java.util.*;

public class IntersectionOfTwoSortedArrays {
    public static List<Integer> intersection(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                // Avoid duplicates in result
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 3, 5, 6};
        List<Integer> res = intersection(arr1, arr2);
        System.out.println("Intersection: " + res);
    }
}
