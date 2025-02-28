package DynamicProgramming;

public class CountBST {

    // Function to count the number of BSTs with n keys
    public static int countBSTs(int n) {
        int[] dp = new int[n + 1];
        
        // Base case
        dp[0] = 1;

        // Fill the dp array using the recursive formula
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4; // Number of keys
        System.out.println("Number of BSTs with " + n + " keys: " + countBSTs(n));
    }
}