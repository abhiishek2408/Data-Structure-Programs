package DynamicProgramming;

class MinPagesDP {

    // Function to find the minimum number of pages using DP (Tabulation)
    static int minPages(int arr[], int n, int k) {
        int[][] dp = new int[k + 1][n + 1];

        // Base case: If there is only one student, assign all pages
        for (int i = 1; i <= n; i++)
            dp[1][i] = dp[1][i - 1] + arr[i - 1];

        // Base case: If there is only one book, each student takes it
        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        // Fill the DP table using Bottom-Up approach
        for (int students = 2; students <= k; students++) { // k students
            for (int books = 2; books <= n; books++) { // n books
                int res = Integer.MAX_VALUE;

                // Try different partition points
                for (int partition = 1; partition < books; partition++) {
                    int maxPages = Math.max(dp[students - 1][partition], sum(arr, partition, books - 1));
                    res = Math.min(res, maxPages);
                }

                dp[students][books] = res;
            }
        }

        return dp[k][n]; // Minimum pages for k students and n books
    }

    // Function to calculate sum of pages from index 'b' to 'e'
    static int sum(int arr[], int b, int e) {
        int total = 0;
        for (int i = b; i <= e; i++)
            total += arr[i];
        return total;
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        int n = arr.length;
        int k = 2; // Number of students

        System.out.println("Minimum number of pages: " + minPages(arr, n, k));
    }
}
