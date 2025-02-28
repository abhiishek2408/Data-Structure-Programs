package DynamicProgramming;

public class OptimalStrategyGame {

    // Function to calculate the optimal strategy
    public static int sol(int[] arr, int i, int j) {
        // Base case: If there are only two coins left
        if (i + 1 == j) {
            return Math.max(arr[i], arr[j]);
        }

        // Calculate the maximum value by choosing either end
        int chooseI = arr[i] + Math.min(sol(arr, i + 2, j), sol(arr, i + 1, j - 1));
        int chooseJ = arr[j] + Math.min(sol(arr, i + 1, j - 1), sol(arr, i, j - 2));

        // Return the maximum of the two choices
        return Math.max(chooseI, chooseJ);
    }

    public static void main(String[] args) {
        int[] arr = {20, 5, 4, 6};
        int n = arr.length;
        System.out.println("Optimal value: " + sol(arr, 0, n - 1));
    }
}