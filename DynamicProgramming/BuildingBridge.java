package DynamicProgramming;

import java.util.*;

    public class BuildingBridge {
    public int maxBridges(int[][] pairs) {
        int n = pairs.length;

        // Step 1: Sort pairs based on the first value, and if equal, sort by the second value
        Arrays.sort(pairs, (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Step 2: Extract second values to apply LIS
        int[] secondValues = new int[n];
        for (int i = 0; i < n; i++) {
            secondValues[i] = pairs[i][1];
        }

        // Step 3: Find LIS on second values
        return lengthOfLIS(secondValues);
    }

    // Function to find LIS using binary search (O(N log N))
    private int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1); // Convert negative index to correct position
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num); // Replace existing value
            }
        }
        return lis.size();
    }

    public static void main(String[] args) {
        BuildingBridge sol = new BuildingBridge();
        int[][] pairs = {{6, 2}, {4, 3}, {2, 6}, {1, 5}, {1, 3}};
        System.out.println(sol.maxBridges(pairs)); // Expected Output: 2
    }
}

