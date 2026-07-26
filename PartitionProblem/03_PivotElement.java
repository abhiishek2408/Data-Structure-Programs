package PartitionProblem;

// Find Pivot Element in Array
// Pivot is the index where sum of elements to the left equals sum to the right

class PivotElement {
        // Alternative approach using prefix and suffix sums
        public int findPivotPrefixSuffix(int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n];
            int[] suffix = new int[n];

            prefix[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = prefix[i - 1] + nums[i];
            }

            suffix[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] + nums[i];
            }

            for (int i = 0; i < n; i++) {
                int left = i == 0 ? 0 : prefix[i - 1];
                int right = i == n - 1 ? 0 : suffix[i + 1];
                if (left == right) {
                    return i;
                }
            }
            return -1;
        }
        
    public int findPivot(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotElement pe = new PivotElement();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index: " + pe.findPivot(nums)); // Output: 3
    }
}
