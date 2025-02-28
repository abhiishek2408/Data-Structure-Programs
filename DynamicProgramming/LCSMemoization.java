package DynamicProgramming;

public class LCSMemoization {

        private static int[][] memo;
    
        public static int lcs(String s1, String s2, int m, int n) {
            if (memo[m][n] != -1)
                return memo[m][n];
            
            if (m == 0 || n == 0) {
                memo[m][n] = 0;
            } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
            } else {
                memo[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
            }
            
            return memo[m][n];
        }
    
        public static void main(String[] args) {
            String s1 = "AXYZ";
            String s2 = "BAZ";
            int m = s1.length();
            int n = s2.length();
            memo = new int[m + 1][n + 1];
    
            // Initialize memoization table with -1
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    memo[i][j] = -1;
                }
            }
    
            System.out.println("Length of LCS: " + lcs(s1, s2, m, n));
        }
    }

