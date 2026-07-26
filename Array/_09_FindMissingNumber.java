package Array;

public class _09_FindMissingNumber {
    public static int findMissingNumber(int[] nums, int n) {
        int totalSum = n * (n + 1) / 2;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
        }
        return totalSum - currentSum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};
        int n = 6;
        System.out.println("Missing number: " + findMissingNumber(nums, n));
    }
}
