
public class MaxSumSubArrayII {
        public static void maxSumSubarrayWithIndices(int[] nums) {
            int maxSum = Integer.MIN_VALUE, currentSum = 0;
            int start = 0, end = 0, tempStart = 0;
    
            for (int i = 0; i < nums.length; i++) {
                currentSum += nums[i];
    
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = tempStart;
                    end = i;
                }
    
                if (currentSum < 0) {
                    currentSum = 0;
                    tempStart = i + 1; // Reset start of subarray
                }
            }
    
            System.out.println("Maximum Sum: " + maxSum);
            System.out.print("Subarray: ");
            for (int i = start; i <= end; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    
        public static void main(String[] args) {
            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            maxSumSubarrayWithIndices(nums);
        }
    }
    

