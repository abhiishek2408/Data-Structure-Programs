package DynamicProgramming;

public class OptimalStrategyGameDP {
   
        // Function to calculate the optimal strategy
        public static int sol(int[] arr, int n) {
            int[][] dp = new int[n][n];
    
            // Fill the table for subproblems of size 2
            for (int i = 0; i < n - 1; i++) {
                dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
            }
    
            // Fill the table for subproblems of size greater than 2
            for (int gap = 3; gap < n; gap += 2) {
                for (int i = 0; i + gap < n; i++) {
                    int j = i + gap;
                    dp[i][j] = Math.max(
                        arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2])
                    );
                }
            }
    
            return dp[0][n - 1];
        }
    
        public static void main(String[] args) {
            int[] arr = {2, 3, 4, 5};
            int n = arr.length;
            System.out.println("Optimal value: " + sol(arr, n));
        }
    }

