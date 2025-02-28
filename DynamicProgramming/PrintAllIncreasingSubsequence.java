package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    public class PrintAllIncreasingSubsequence {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }
        
        Set<Integer> used = new HashSet<>();
        
        for (int i = start; i < nums.length; i++) {
            if (!current.isEmpty() && nums[i] < current.get(current.size() - 1)) {
                continue;
            }
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        PrintAllIncreasingSubsequence solution = new PrintAllIncreasingSubsequence();
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> subsequences = solution.findSubsequences(nums);
        System.out.println("Increasing Subsequences: " + subsequences);
    }
}

