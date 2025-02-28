package Monotonocity;
public class ProductofArrayExceptSelf {
    
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];
        
        // Compute prefix products
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        
        // Compute suffix products
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        
        // Compute result by multiplying prefix and suffix products
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        for (int k : productExceptSelf(arr)) {
            System.out.print(k+" ");
        }
    }
}
