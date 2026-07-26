package Monotonocity;

public class PrefixSuffixProduct {

    // Method to compute prefix products
    private static int[] computePrefixProducts(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        return prefix;
    }

    // Method to compute suffix products
    private static int[] computeSuffixProducts(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        return suffix;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        // Compute and print prefix array
        int[] prefix = computePrefixProducts(arr);
        System.out.print("Prefix Array: ");
        for (int p : prefix) {
            System.out.print(p + " ");
        }
        System.out.println();

        // Compute and print suffix array
        int[] suffix = computeSuffixProducts(arr);
        System.out.print("Suffix Array: ");
        for (int s : suffix) {
            System.out.print(s + " ");
        }
    }
}
