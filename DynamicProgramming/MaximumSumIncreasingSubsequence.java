package DynamicProgramming;


import java.util.Scanner;

class MaximumSumIncreasingSubsequence {
    public int maxSumIS(int[] arr, int n) {
        int[] dp = new int[n];
        int maxSum = 0;

        // Initialize msis[] with the same values as arr[]
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        // Compute MSIS values
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        // Find the maximum sum in msis[]
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        MaximumSumIncreasingSubsequence solution = new MaximumSumIncreasingSubsequence();
        int result = solution.maxSumIS(arr, n);
        System.out.println("Maximum Sum Increasing Subsequence: " + result);

        scanner.close();
    }
}

