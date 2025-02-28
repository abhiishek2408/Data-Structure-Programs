package DynamicProgramming;

public class MatrixChainMultiplication {
    // Recursive function to find the minimum number of multiplications needed
    public static int mChain(int[] arr, int i, int j) {
        if (i + 1 == j) // Only one matrix
            return 0;

        int res = Integer.MAX_VALUE;

        // Try different partitions
        for (int k = i + 1; k < j; k++) {
            int cost = mChain(arr, i, k) + mChain(arr, k, j) + arr[i] * arr[k] * arr[j];
            res = Math.min(res, cost);
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30}; // Example matrix dimensions
        int n = arr.length;

        System.out.println("Minimum number of multiplications: " + mChain(arr, 0, n - 1));
    }
}

