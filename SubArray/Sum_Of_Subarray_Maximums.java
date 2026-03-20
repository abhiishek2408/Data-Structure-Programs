import java.util.Stack;
//Thus, the function finds the total contribution of each element when it is the maximum in all its valid subarrays

public class Sum_Of_Subarray_Maximums {

    private long getMaxContribution(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        // Iterate through the array
        for (int i = 0; i <= n; i++) {
            // We push an extra element at the end to ensure all elements in stack are processed
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {
                int currentIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;

                // Number of subarrays where nums[currentIndex] is the maximum
                long leftCount = currentIndex - leftIndex;
                long rightCount = rightIndex - currentIndex;
                long totalSubarrays = leftCount * rightCount;

                // Contribution of this element as max
                sum += totalSubarrays * nums[currentIndex];
            }

            // Push current index into the stack
            stack.push(i);
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Sum_Of_Subarray_Maximums calculator = new Sum_Of_Subarray_Maximums();

        // Example array
        int[] nums = {3, 1, 4, 2};

        // Calculate and print the maximum subarray contribution sum
        long result = calculator.getMaxContribution(nums);
        System.out.println("Total max subarray contribution: " + result);
    }
}


/*Key Observations
The stack maintains indices of elements in increasing order.
When popping, it determines the range in which the popped element is the maximum.
Each element contributes based on the number of subarrays where it is the max.

Complexity
Each element is pushed and popped from the stack at most once, making the time complexity O(n). */