public class NumberOfSubArray_Sum_Equalto_K_Naive {
    public static int SumEqualtok(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currSum = 0; // Reset currSum for each new starting index
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                if (currSum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(SumEqualtok(nums, 2)); // Output should be 2
    }
}