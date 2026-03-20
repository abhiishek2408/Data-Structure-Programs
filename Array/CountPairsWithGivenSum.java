package Array;

import java.util.HashMap;

public class CountPairsWithGivenSum {
    // Function to count pairs with given sum
    public static int getPairsCount(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int value : arr) {
            int complement = sum - value;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return count;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int sum = 6;
        System.out.println("Count of pairs is " + getPairsCount(arr, sum));
    }
}
