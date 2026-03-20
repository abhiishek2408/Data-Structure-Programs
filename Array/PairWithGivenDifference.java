package Array;
// Problem: Find all pairs in an array with a given difference
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

public class PairWithGivenDifference {
    // Returns all pairs in arr[] with difference equal to diff
        // Returns a 1D array of the first elements of all pairs with given difference
        public static int[] printPairs(int[] arr, int diff) {
            HashSet<Integer> set = new HashSet<>();
            List<Integer> result = new ArrayList<>();
            for (int num : arr) {
                set.add(num);
            }
            for (int num : arr) {
                if (set.contains(num + diff)) {
                    result.add(num);
                }
                if (set.contains(num - diff)) {
                    result.add(num);
                }
                set.remove(num);
            }
            
            int[] resArr = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                resArr[i] = result.get(i);
            }
            return resArr;
        }
    

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int diff = 2;
            int[] result = printPairs(arr, diff);
            System.out.println("Elements with a pair of difference " + diff + ":");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

