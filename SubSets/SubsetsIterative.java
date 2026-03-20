package SubSets;

import java.util.*;

public class SubsetsIterative {
    public static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Start with empty subset // Initially, it only contains the empty subset

        for (int num : arr) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));// Copy existing subset []
                newSubset.add(num); // Add 1 → newSubset = [1]
                result.add(newSubset); // Add [1] to result
            }                         //result become  [ [], [1] ]

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(arr);
        System.out.println(subsets);
    }
}
