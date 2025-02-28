package DynamicProgramming;

import java.util.*;

class MaximumBitonicSubsequence {
    public int longestBitonicSubsequence(int[] arr, int n) {
        int[] lis = new int[n]; // Longest Increasing Subsequence
        int[] lds = new int[n]; // Longest Decreasing Subsequence

        // Compute LIS values
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Compute LDS values
        Arrays.fill(lds, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        // Compute maximum of lis[i] + lds[i] - 1
        int maxBitonic = 0;
        for (int i = 0; i < n; i++) {
            maxBitonic = Math.max(maxBitonic, lis[i] + lds[i] - 1);
        }

        return maxBitonic;
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

        MaximumBitonicSubsequence solution = new MaximumBitonicSubsequence();
        int result = solution.longestBitonicSubsequence(arr, n);
        System.out.println("Maximum Length Bitonic Subsequence: " + result);

        scanner.close();
    }
}
