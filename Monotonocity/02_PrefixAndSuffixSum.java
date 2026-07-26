package Monotonocity;

public class PrefixAndSuffixSum {

    // Method to compute prefix sums
    private static int[] computePrefixSums(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }

    // Method to compute suffix sums
    private static int[] computeSuffixSums(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        return suffix;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        // Compute and print prefix sum array
        int[] prefix = computePrefixSums(arr);
        System.out.print("Prefix Sum Array: ");
        for (int p : prefix) {
            System.out.print(p + " ");
        }
        System.out.println();

        // Compute and print suffix sum array
        int[] suffix = computeSuffixSums(arr);
        System.out.print("Suffix Sum Array: ");
        for (int s : suffix) {
            System.out.print(s + " ");
        }
    }
}
