package DynamicProgramming;

import java.util.*;

class MinimumDeletionsToSortBinarySearch {
    public int minDeletionsToSort(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            int idx = Collections.binarySearch(sub, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx < sub.size()) {
                sub.set(idx, num);
            } else {
                sub.add(num);
            }
        }

        return nums.length - sub.size();
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

        MinimumDeletionsToSortBinarySearch solution = new MinimumDeletionsToSortBinarySearch();
        int result = solution.minDeletionsToSort(nums);
        System.out.println("Minimum deletions to make array sorted: " + result);
        scanner.close();
    }
}

