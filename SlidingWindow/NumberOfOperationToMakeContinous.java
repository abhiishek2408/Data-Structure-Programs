package SlidingWindow;

import java.util.Arrays;

class NumberOfOperationToMakeContinous {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Remove duplicates using a loop
        int[] uniqueNums = new int[n]; // At most n unique elements
        int uniqueSize = 0;  // Number of unique elements

        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                uniqueNums[uniqueSize++] = nums[i];
            }
        }

        // Step 3: Use a sliding window to find the max valid continuous sequence
        int maxValidWindow = 0;
        int left = 0;

        for (int right = 0; right < uniqueSize; right++) {
            while (uniqueNums[right] - uniqueNums[left] >= n) {
                left++;
            }
            maxValidWindow = Math.max(maxValidWindow, right - left + 1);
        }

        // Step 4: Compute the minimum operations needed
        return n - maxValidWindow;
    }

    public static void main(String[] args) {
        NumberOfOperationToMakeContinous sol = new NumberOfOperationToMakeContinous();
        System.out.println(sol.minOperations(new int[]{4,2,5,3})); // Output: 0
        System.out.println(sol.minOperations(new int[]{1,2,3,5,6})); // Output: 1
        System.out.println(sol.minOperations(new int[]{1,10,100,1000})); // Output: 3
    }
}

/*A continuous sequence in this problem means:

All elements are unique (no duplicates).
The numbers form a consecutive sequence, meaning the difference between the maximum and minimum value equals nums.length - 1.

Modify numbers with the minimum replacements to make it continuous.

Example:

Input: [1,10,100,1000]
Change 10 → 2, 100 → 3, 1000 → 4
Result: [1,2,3,4] → Now continuous!
*/