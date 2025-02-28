package DynamicProgramming;

public class PalindromePartitioningDP {
    
        // Function to check if a substring is a palindrome
        static boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    
        // Function to find the minimum number of partitions needed
        static int palPart(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
    
            // Step 1: Base case - Single character substrings are palindromes
            for (int i = 0; i < n; i++) {
                dp[i][i] = 0;
            }
    
            // Step 2: Fill the table for substrings of length 2 and above
            for (int gap = 1; gap < n; gap++) {  // gap represents substring length difference
                for (int i = 0; i + gap < n; i++) {
                    int j = i + gap;
    
                    // Step 3: Check if the substring is already a palindrome
                    if (isPalindrome(s, i, j)) {
                        dp[i][j] = 0;  // No partitions needed
                    } else {
                        dp[i][j] = Integer.MAX_VALUE;
    
                        // Step 4: Try every possible partition point and find the minimum cuts
                        for (int k = i; k < j; k++) {
                            dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                        }
                    }
                }
            }
    
            // The answer is stored in dp[0][n-1]
            return dp[0][n - 1];
        }
    
        public static void main(String[] args) {
            String str = "geek";
            System.out.println("Minimum cuts needed for Palindrome Partitioning: " + palPart(str));
        }
    }
    
