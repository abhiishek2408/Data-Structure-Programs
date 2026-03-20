package Subsequence;

import java.util.Scanner;

public class SCSofArray {

    public int shortestCommonSupersequence(int[] arr1, int[] arr2) {
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
        
        int lcsLength = dp[m][n];
        return m + n - lcsLength; // SCS length formula
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
        
        SCSofArray solution = new SCSofArray();
        int result = solution.shortestCommonSupersequence(arr1, arr2);
        System.out.println("Shortest Common Supersequence length: " + result);
        
        scanner.close();
    }
}

