import java.util.*;

class TwoDifferenceAllPairs {
    public List<List<Integer>> allPairsWithDifference(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<String> seenPairs = new HashSet<>(); // to avoid duplicates
        
        for (int num : nums) {
            if (set.contains(num + k)) {
                String key = Math.min(num, num + k) + "," + Math.max(num, num + k);
                if (!seenPairs.contains(key)) {
                    result.add(Arrays.asList(num, num + k));
                    seenPairs.add(key);
                }
            }
            if (set.contains(num - k)) {
                String key = Math.min(num, num - k) + "," + Math.max(num, num - k);
                if (!seenPairs.contains(key)) {
                    result.add(Arrays.asList(num, num - k));
                    seenPairs.add(key);
                }
            }
            set.add(num);
        }
        
        return result;
    }


    

    public static void main(String[] args) {
        TwoDifferenceAllPairs solution = new TwoDifferenceAllPairs();
        int[] nums = {1, 5, 3, 4, 2};
        int k = 2;

        List<List<Integer>> result = solution.allPairsWithDifference(nums, k);
        System.out.println("All pairs with difference " + k + ": " + result);
    }
}


