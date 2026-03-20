package Array;
//Find common elements in 3 sorted arrays
// IntersectionOfThreeSortedArrays.java
// LeetCode 1213: Intersection of Three Sorted Arrays
// Time Complexity: O(n1 + n2 + n3)

import java.util.*;

public class IntersectionOfThreeSortedArrays {
    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                int min = Math.min(arr1[i], Math.min(arr2[j], arr3[k]));
                if (arr1[i] == min) i++;
                if (arr2[j] == min) j++;
                if (arr3[k] == min) k++;
            }
        }
        return result;
    }

  //Find common elements in 3 sorted arrays
    public static List<Integer> commonElements(int[] a, int[] b, int[] c) {
        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length && k < c.length) {

            // If all three are equal
            if (a[i] == b[j] && b[j] == c[k]) {
                // Avoid duplicates
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) {
                    result.add(a[i]);
                }
                i++;
                j++;
                k++;
            }
            // Move the pointer with smallest value
            else if (a[i] < b[j]) {
                i++;
            } else if (b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        List<Integer> res = arraysIntersection(arr1, arr2, arr3);
        System.out.println("Intersection: " + res);
    }
}
