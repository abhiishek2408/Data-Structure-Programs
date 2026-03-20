 

public class RangeSum {

    public static int rangeSum(int[] nums, int left, int right) {

        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        int left = 1;
        int right = 3;

        System.out.println(rangeSum(nums, left, right));
    }
    


}
