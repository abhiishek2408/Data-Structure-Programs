package DynamicProgramming;

public class MaxSumNonAdjacentDP {

        // Function to find the maximum sum of non-adjacent elements using DP
        public static int maxSum(int[] arr) {
            int n = arr.length;
            if (n == 0) return 0;
            if (n == 1) return arr[0];
    
            int[] dp = new int[n];
            dp[0] = arr[0];
            dp[1] = Math.max(arr[0], arr[1]);
    
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
            }
    
            return dp[n - 1];
        }
    
        public static void main(String[] args) {
            int[] arr = {10, 5, 15, 20};
            System.out.println("Maximum sum of non-adjacent elements: " + maxSum(arr));
        }
    } 

