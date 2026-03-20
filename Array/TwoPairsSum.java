import java.util.*;

public class TwoPairsSum {

    public static List<List<Integer>> allPairsSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int num : arr) {
            int diff = target - num;
            
            // If diff exists in map, add pairs
            if (map.containsKey(diff)) {
                int count = map.get(diff);
                for (int i = 0; i < count; i++) {
                    result.add(Arrays.asList(diff, num));
                }
            }
            
            // Add current num to map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return result;
    }

    public static List<List<Integer>> allPairsSumWithoutLoop(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int num : arr) {
            int diff = target - num;
            
            // If diff exists in map, add ONE pair only
            if (map.containsKey(diff)) {
                result.add(Arrays.asList(diff, num));
            }
            
            // Add current num to map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 2, 7};
        int target = 9;

        List<List<Integer>> pairs = allPairsSum(arr, target);
        System.out.println(pairs);
    }
}

