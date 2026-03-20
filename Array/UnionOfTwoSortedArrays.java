package Array;

import java.util.*;

public class UnionOfTwoSortedArrays {
    // Returns the union of two sorted arrays as a list
 
    public static List<Integer> unionSortedArrays(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                addUnique(result, a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                addUnique(result, a[i]);
                i++;
            } else {
                addUnique(result, b[j]);
                j++;
            }
        }

        while (i < a.length) {
            addUnique(result, a[i++]);
        }

        while (j < b.length) {
            addUnique(result, b[j++]);
        }

        return result;
    }

    private static void addUnique(List<Integer> res, int val) {
        if (res.isEmpty() || res.get(res.size() - 1) != val) {
            res.add(val);
        }
    }



    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};
        List<Integer> union = unionSortedArrays(arr1, arr2);
        System.out.println("Union of two sorted arrays: " + union);
    }
}
