package DynamicProgramming;

class MinPagesRecursive {

    // Function to calculate sum of elements from index 'b' to 'e'
    static int sum(int arr[], int b, int e) {
        int total = 0;
        for (int i = b; i <= e; i++) {
            total += arr[i];
        }
        return total;
    }

    // Function to find the minimum number of pages
    static int minPages(int arr[], int n, int k) {
        // Base cases
        if (k == 1)  // Only one student, sum of all pages
            return sum(arr, 0, n - 1);
        if (n == 1)  // Only one book, one student must take it
            return arr[0];

        int res = Integer.MAX_VALUE;

        // Consider all possible partitions
        for (int i = 1; i < n; i++) {
            res = Math.min(res, Math.max(minPages(arr, i, k - 1), sum(arr, i, n - 1)));
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        int n = arr.length;
        int k = 2; // Number of students

        System.out.println("Minimum number of pages: " + minPages(arr, n, k));
    }
}
