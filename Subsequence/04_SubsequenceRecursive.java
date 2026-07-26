package Subsequence;

import java.util.*;

public class SubsequenceRecursive {
    public static void generateSubsequences(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Exclude current element
        generateSubsequences(arr, index + 1, current);

        // Include current element
        current.add(arr[index]);
        generateSubsequences(arr, index + 1, current);

        // Backtrack (remove the last element)
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generateSubsequences(arr, 0, new ArrayList<>());
    }
}
