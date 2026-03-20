package Subsequence;

import java.util.Scanner;

public class SCSofString {
    public int shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
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
        
        System.out.print("Enter first string: ");
        String text1 = scanner.nextLine();
        
        System.out.print("Enter second string: ");
        String text2 = scanner.nextLine();
        
        SCSofString solution = new SCSofString();
        int result = solution.shortestCommonSupersequence(text1, text2);
        System.out.println("Shortest Common Supersequence length: " + result);
        
        scanner.close();
    }
}

