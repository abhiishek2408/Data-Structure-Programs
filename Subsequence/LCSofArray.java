package Subsequence;

import java.util.Scanner;

class LCSofArray {
    public int longestCommonSubsequence(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter size of first array: ");
        int m = scanner.nextInt();
        int[] arr1 = new int[m];
        System.out.println("Enter elements of first array: ");
        for (int i = 0; i < m; i++) {
            arr1[i] = scanner.nextInt();
        }
        
        System.out.print("Enter size of second array: ");
        int n = scanner.nextInt();
        int[] arr2 = new int[n];
        System.out.println("Enter elements of second array: ");
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }
        
        LCSofArray solution = new LCSofArray();
        int result = solution.longestCommonSubsequence(arr1, arr2);
        System.out.println("Longest Common Subsequence length: " + result);
        
        scanner.close();
    }
}
