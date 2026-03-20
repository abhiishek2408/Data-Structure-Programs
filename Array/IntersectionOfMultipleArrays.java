package Array;

// IntersectionOfMultipleArrays.java
// LeetCode 2248: Intersection of Multiple Arrays
// Time Complexity: O(n * m) where n = number of arrays, m = average array length

import java.util.*;

public class IntersectionOfMultipleArrays {
   public List<Integer> intersection(int[][] nums) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        int rows = nums.length;

        // Count frequency of each number across rows
        for (int[] row : nums) {
            for (int num : row) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Number must appear in all rows
        for (int key : freq.keySet()) {
            if (freq.get(key) == rows) {
                result.add(key);
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(3, 1, 2, 4, 5));
        arrays.add(Arrays.asList(1, 2, 3, 4));
        arrays.add(Arrays.asList(3, 4, 5, 6));
        int[][] nums = new int[arrays.size()][];
        for (int i = 0; i < arrays.size(); i++) {
            nums[i] = arrays.get(i).stream().mapToInt(Integer::intValue).toArray();
        }

        IntersectionOfMultipleArrays solution = new IntersectionOfMultipleArrays();
        List<Integer> intersection = solution.intersection(nums);
        System.out.println("Intersection: " + intersection);
    }
}
