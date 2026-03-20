package Array;
// SmallestCommonElementInAllRows.java
// Finds the smallest common element in all rows of a matrix
// Time Complexity: O(m * n) where m = number of rows, n = number of columns

import java.util.*;

public class SmallestCommonElementInAllRows {

    public static int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> freq = new HashMap<>();
        int rows = mat.length;

        for (int[] row : mat) {
            for (int num : row) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int key : freq.keySet()) {
            if (freq.get(key) == rows) {
                ans = Math.min(ans, key);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }



    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4, 5},
            {2, 4, 5, 8, 10},
            {4, 5, 8, 9, 10}
        };
        int res = smallestCommonElement(mat);
        System.out.println("Smallest Common Element: " + res);
    }
}
