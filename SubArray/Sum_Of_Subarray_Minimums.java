import java.util.Stack;

public class Sum_Of_Subarray_Minimums {
    private static long getMinContribution(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        // Iterate through the array
        for (int i = 0; i <= n; i++) {
            // We push an extra element at the end to ensure all elements in stack are processed
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int currentIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;

                // Number of subarrays where nums[currentIndex] is the minimum
                long leftCount = currentIndex - leftIndex;
                long rightCount = rightIndex - currentIndex;
                long totalSubarrays = leftCount * rightCount;

                // Contribution of this element as min
                sum += totalSubarrays * nums[currentIndex];
            }

            // Push current index into the stack
            stack.push(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        long result = getMinContribution(nums);
        System.out.println("Minimum Contribution: " + result);
    }
}



/*
The issue with your approach is integer overflow. In Java, an int can only store 
values up to 2,147,483,647. Since you're summing large numbers (sum += totalSubarrays * nums[currentIndex]), 
the value exceeds this limit, causing negative results due to overflow.

How to Fix the Issue
Use modulo arithmetic with 10^9 + 7 (1_000_000_007), and ensure all intermediate calculations remain within bounds.


public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int MOD = 1_000_000_007;
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int currentIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;

                long leftCount = currentIndex - leftIndex;
                long rightCount = rightIndex - currentIndex;
                long totalSubarrays = (leftCount * rightCount) % MOD; // Prevent overflow

                sum = (sum + (totalSubarrays * nums[currentIndex]) % MOD) % MOD;
            }
            stack.push(i);
        }

        return (int) sum;
    }
    } */

