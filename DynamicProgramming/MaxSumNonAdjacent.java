package DynamicProgramming;

public class MaxSumNonAdjacent {

    // Recursive function to find the maximum sum of non-adjacent elements
    public static int maxSum(int[] arr, int n) {
        // Base cases
        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return Math.max(arr[0], arr[1]);
        }

        // Recursive case
        return Math.max(maxSum(arr, n - 1), maxSum(arr, n - 2) + arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 15, 20};
        int n = arr.length;
        System.out.println("Maximum sum of non-adjacent elements: " + maxSum(arr, n));
    }
}