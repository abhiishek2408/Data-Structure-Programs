package DynamicProgramming;

class MinimumJumps {
    // Recursive function to find the minimum number of jumps to reach the end
    static int minJump(int arr[], int n) {
        // Base case: If we are at the first element, no jumps are needed
        if (n == 1) return 0;

        // Initialize result to a large number (Integer.MAX_VALUE)
        int res = Integer.MAX_VALUE;

        // Check all positions from which we can jump to the last position
        for (int i = 0; i <= n - 2; i++) {
            if (i + arr[i] >= n - 1) { // If we can jump to or beyond the last index  If we are at index i, we check if i + arr[i] (reachable position) is at least n-1 (last index).
                                           // If true, then we can reach the last index from i.
                int subRes = minJump(arr, i + 1); // Recursively find jumps needed from start to i
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 1, 2, 3, 1}; // Sample array
        int n = arr.length;

        int result = minJump(arr, n);
        System.out.println("Minimum jumps required: " + result);
    }
}
