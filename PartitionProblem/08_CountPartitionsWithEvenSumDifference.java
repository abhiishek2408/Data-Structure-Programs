package PartitionProblem;

public class CountPartitionsWithEvenSumDifference {
    public static int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        int count = 0;
        // Partition at i: left [0..i], right [i+1..n-1]
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;
            int diff = leftSum - rightSum;
            if (diff % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countPartitions2(int[] nums) {
         int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // if total sum is odd, no valid partition
        if (totalSum % 2 != 0) {
            return 0;
        }

        // total sum even => all n-1 partitions valid
        return nums.length - 1;
    }

    // Example usage and test cases
    public static void main(String[] args) {
        int[] nums1 = {10, 10, 3, 7, 6};
        System.out.println(countPartitions(nums1)); // Output: 4
        System.out.println(countPartitions2(nums1)); // Output: 4

        int[] nums2 = {1, 2, 2};
        System.out.println(countPartitions(nums2)); // Output: 0
        System.out.println(countPartitions2(nums2)); // Output: 0

        int[] nums3 = {2, 4, 6, 8};
        System.out.println(countPartitions(nums3)); // Output: 3
        System.out.println(countPartitions2(nums3)); // Output: 3
    }
}
