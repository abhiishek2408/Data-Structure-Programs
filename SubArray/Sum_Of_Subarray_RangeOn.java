import java.util.Stack;

public class Sum_Of_Subarray_RangeOn {

    public long subArrayRanges(int[] nums) {
        long sumOfMaxContributions = getMaxContribution(nums);
        long sumOfMinContributions = getMinContribution(nums);
        return sumOfMaxContributions - sumOfMinContributions;
    }

    private long getMaxContribution(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {
                int currentIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;
                long leftCount = currentIndex - leftIndex;
                long rightCount = rightIndex - currentIndex;
                long totalSubarrays = leftCount * rightCount;
                sum += totalSubarrays * nums[currentIndex];
            }
            stack.push(i);
        }
        return sum;
    }

    private long getMinContribution(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int currentIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;
                long leftCount = currentIndex - leftIndex;
                long rightCount = rightIndex - currentIndex;
                long totalSubarrays = leftCount * rightCount;
                sum += totalSubarrays * nums[currentIndex];
            }
            stack.push(i);
        }
        return sum;
    }


    public static void main(String[] args) {
        Sum_Of_Subarray_RangeOn solution = new Sum_Of_Subarray_RangeOn();

        int[] nums1 = {1, 2, 3};
        System.out.println("Output: " + solution.subArrayRanges(nums1)); // Expected output: 4

        int[] nums2 = {4, 1, 3, 2};
        System.out.println("Output: " + solution.subArrayRanges(nums2)); // Expected output: 14

        int[] nums3 = {10, 20, 30};
        System.out.println("Output: " + solution.subArrayRanges(nums3)); // Expected output: 40
    }
}


