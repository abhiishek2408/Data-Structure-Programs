package DynamicProgramming;

import java.util.*;

    public class LongestChainOfPairGreedyApproach {
    public int findLongestChain(int[][] pairs) {
        // Step 1: Sort pairs based on the second element for greedy approach
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Use Greedy approach to select non-overlapping pairs
        int count = 0, lastEnd = Integer.MIN_VALUE;
        for (int[] pair : pairs) {
            if (pair[0] > lastEnd) { // If this pair can be chained
                count++;
                lastEnd = pair[1]; // Update last ending value
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        LongestChainOfPairGreedyApproach sol = new LongestChainOfPairGreedyApproach();
        int[][] pairs = {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}};
        System.out.println(sol.findLongestChain(pairs)); // Expected Output: 3
    }
}

