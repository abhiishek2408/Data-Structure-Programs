package DynamicProgramming;

public class ShortestCommonSuperSubsequence {
        public String shortestCommonSupersequence(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();
            
            // Step 1: Find the LCS
            int[][] dp = new int[m + 1][n + 1];
            
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            
            // Step 2: Construct the SCS using the LCS
            StringBuilder scs = new StringBuilder();
            int i = m, j = n;
            
            while (i > 0 && j > 0) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    scs.append(str1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    scs.append(str1.charAt(i - 1));
                    i--;
                } else {
                    scs.append(str2.charAt(j - 1));
                    j--;
                }
            }
            
            // Add remaining characters of str1
            while (i > 0) {
                scs.append(str1.charAt(i - 1));
                i--;
            }
            
            // Add remaining characters of str2
            while (j > 0) {
                scs.append(str2.charAt(j - 1));
                j--;
            }
            
            // The SCS is constructed in reverse order
            return scs.reverse().toString();
        }
    
        public static void main(String[] args) {
            ShortestCommonSuperSubsequence solution = new ShortestCommonSuperSubsequence();
            
            // Example test cases
            String str1 = "abac";
            String str2 = "cab";
            //output: "cabac"
            String result = solution.shortestCommonSupersequence(str1, str2);
            System.out.println("Shortest Common Supersequence of \"" + str1 + "\" and \"" + str2 + "\" is: \"" + result + "\"");
            
            // You can add more test cases here
        }
    }

/*Find the Longest Common Subsequence (LCS): Use dynamic programming to find the LCS of str1 and str2. 
This will help in constructing the SCS.

Construct the Shortest Common Supersequence (SCS): Use the LCS to merge str1 and str2 into the shortest 
sequence that contains both as subsequences. */

