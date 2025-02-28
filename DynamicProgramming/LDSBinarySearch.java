package DynamicProgramming;

import java.util.*;


    public class LDSBinarySearch {
    public int lengthOfLDS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        
        for (int num : nums) {
            int idx = Collections.binarySearch(sub, num, Collections.reverseOrder());
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx < sub.size()) {
                sub.set(idx, num); // Replace element
            } else {
                sub.add(num); // Extend sequence
            }
        }

        return sub.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        LDSBinarySearch sol = new LDSBinarySearch();
        int result = sol.lengthOfLDS(nums);
        System.out.println("Length of Longest Decreasing Subsequence: " + result);
        scanner.close();
    }
}

