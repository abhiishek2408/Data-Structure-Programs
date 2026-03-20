package Array;

// GenerateArrayBasedOnGivenWay.java
// Problem: Generate an array based on a given pattern or rule

public class GenerateArrayBasedOnGivenWay {
    /**
     * Example: Generate an array where each element is double the previous, starting from 1.
     * @param n Length of the array
     * @return Generated array
     */
    public int[] generateDoubleArray(int n) {
        int[] arr = new int[n];
        if (n == 0) return arr;
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * 2;
        }
        return arr;
    }

    // Example usage
    public static void main(String[] args) {
        GenerateArrayBasedOnGivenWay solution = new GenerateArrayBasedOnGivenWay();
        int[] arr = solution.generateDoubleArray(8);
        System.out.print("Generated array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
