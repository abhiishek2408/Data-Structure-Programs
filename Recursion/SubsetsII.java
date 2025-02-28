package Recursion;

import java.util.*;


class SubsetsII {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), list);
        return list;
    }

    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        
       if(nums[index-1] == nums[index]){
            current.remove(nums[index]);
        }
        // Exclude the current element
        generateSubsets(index + 1, nums, current, list);
        
       
        // // Include the current element
        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, list);

        // // Backtrack
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        List<List<Integer>> result = subsets(arr);
        System.out.println(result); // Print the generated subsets
    }
}
