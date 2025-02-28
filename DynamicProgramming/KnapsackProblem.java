package DynamicProgramming;

class KnapsackProblem {
    // Recursive function to solve the 0-1 Knapsack problem
    static int knapsack(int W, int wt[], int val[], int n) {
        // Base case: If no items are left or capacity is zero
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, exclude it
        if (wt[n - 1] > W)
            return knapsack(W, wt, val, n - 1);

        // Return the maximum of two cases:
        // 1. Excluding the nth item
        // 2. Including the nth item
        return Math.max(
            knapsack(W, wt, val, n - 1), 
            val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1)
        );
    }

    public static void main(String args[]) {
        int val[] = {10, 40, 30, 50};  // Values of items
        int wt[] = {5, 4, 6, 3};       // Weights of items
        int W = 10;                    // Knapsack capacity
        int n = val.length;            // Number of items

        int maxProfit = knapsack(W, wt, val, n);
        System.out.println("Maximum value in Knapsack = " + maxProfit);
    }
}
