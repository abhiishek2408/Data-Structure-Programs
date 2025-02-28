package DynamicProgramming;


class MaximumCutsRecursive {
    // Recursive function to find the maximum number of cuts
    static int maxCuts(int n, int a, int b, int c) {
        // Base case: If n becomes negative, return -1 (invalid case)
        if (n < 0) return -1;
        // Base case: If n is exactly zero, return 0 (valid case)
        if (n == 0) return 0;

        // Recursive case: Get the maximum cuts possible
        int res = Math.max(
            Math.max(maxCuts(n - a, a, b, c), maxCuts(n - b, a, b, c)),
            maxCuts(n - c, a, b, c)
        );

        // If no valid cuts are possible, return -1
        if (res == -1) return -1;

        // Otherwise, return the count of cuts
        return res + 1;
    }

    public static void main(String[] args) {
        int n = 5, a = 1, b = 2, c = 3;
        System.out.println("Maximum cuts possible: " + maxCuts(n, a, b, c));
    }
}

