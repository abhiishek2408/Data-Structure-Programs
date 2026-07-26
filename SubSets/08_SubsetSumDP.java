package SubSets;

//package DynamicProgramming;

public class SubsetSumDP {
    public static int countSubsets(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        // Initialize the first column: 1 way to get sum = 0 (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];  // Exclude current element
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];  // Include + Exclude
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15};
        int sum = 25;
        int n = arr.length;

        System.out.println("Number of subsets with sum " + sum + " is " + countSubsets(arr, n, sum));
    }
}
