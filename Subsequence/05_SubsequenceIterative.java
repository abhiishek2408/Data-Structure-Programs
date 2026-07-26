package Subsequence;

import java.util.*;

public class SubsequenceIterative {
    public static List<List<Integer>> generateSubsequences(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Start with empty subsequence

        for (int num : arr) {
            int size = result.size();

            for (int i = 0; i < size; i++) {
                List<Integer> newSubsequence = new ArrayList<>(result.get(i));
                newSubsequence.add(num);
                result.add(newSubsequence);
            }
        }

        result.remove(0); // Remove the empty subsequence []
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsequences = generateSubsequences(arr);

        for (List<Integer> seq : subsequences) {
            System.out.println(seq);
        }
    }
}

