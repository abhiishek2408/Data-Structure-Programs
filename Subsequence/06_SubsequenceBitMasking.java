package Subsequence;

import java.util.*;

public class SubsequenceBitMasking {
    public static void printAllSubsequences(int[] arr) {
        int n = arr.length;
        int totalSubsequences = 1 << n; // 2^n subsets

        for (int mask = 0; mask < totalSubsequences; mask++) {
            List<Integer> subsequence = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // If i-th bit is set, include arr[i]
                    subsequence.add(arr[i]);
                }
            }
            System.out.println(subsequence);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printAllSubsequences(arr);
    }
}
