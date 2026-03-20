

public class MaxProductSubArray {
        public int maxProduct(int[] nums) {

            if (nums == null || nums.length == 0) return 0;
    

            int maxProduct = nums[0];
            int currentMax = nums[0];
            int currentMin = nums[0];
    
            // Loop through the array starting from the second element
            for (int i = 1; i < nums.length; i++) {
                int currentNum = nums[i];
    
                // If the current number is negative, swap the max and min
                if (currentNum < 0) {
                    int temp = currentMax;
                    currentMax = currentMin;
                    currentMin = temp;
                }
    
                // Update the current maximum and minimum products
                currentMax = Math.max(currentNum, currentNum * currentMax);
                currentMin = Math.min(currentNum, currentNum * currentMin);
    
                // Update the global maximum product
                maxProduct = Math.max(maxProduct, currentMax);
            }
    
            // Return the global maximum product found
            return maxProduct;
        }
        public static void main(String[] args) {
            MaxProductSubArray solution = new MaxProductSubArray();
            int[] nums = {-2, 3, -4};
            System.out.println(solution.maxProduct(nums)); // Output: 24
        }
}
