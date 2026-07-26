package SubSets;

import java.util.Arrays;

public class SubsetBinaryCheckSearch {
    public static boolean binarySearch(int[] A, int key) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == key) return true;
            if (A[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static boolean isSubset(int[] A, int[] B) {
        Arrays.sort(A); // Sort A
        for (int b : B) {
            if (!binarySearch(A, b)) return false; // Check each element using binary search
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 6};
        System.out.println(isSubset(A, B) ? "Yes" : "No"); // Output: No
    }
}
