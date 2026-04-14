package DynamicProgramming;
// Longest Palindromic Subsequence problem
// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting 
// some or no elements without changing the order of the remaining elements.
// Time complexity: O(n^2) where n is the length of the input string
// Space complexity: O(n^2) for the 2D dp array and O(n) for the optimized space complexity version

// Subsequence: A subsequence is a sequence that can be derived from another sequence by deleting 
// some or no elements without changing the order of the remaining elements. 
// For example, "abc", "abg", "bdf", "aeg", '"acefg", .. etc are subsequences of "abcdefg". "abc" 
// is a subsequence of "abc", but "acb" is not a subsequence of "abc" because the order of characters is different.
public class LongestPalindromicSubsequence {
    
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // base case: single characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // fill the dp table
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
