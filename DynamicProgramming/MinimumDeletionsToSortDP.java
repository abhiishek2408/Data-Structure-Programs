package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

class MinimumDeletionsToSortDP {
    public int minDeletionsToSort(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return n - maxLIS;
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

        MinimumDeletionsToSortDP solution = new MinimumDeletionsToSortDP();
        int result = solution.minDeletionsToSort(nums);
        System.out.println("Minimum deletions to make array sorted: " + result);
        scanner.close();
    }
}

/*The longest increasing subsequence (LIS) gives the largest subset of numbers that are already sorted.

The minimum deletions required to sort the array is: Deletions=Length of Array−Length of LIS
 */