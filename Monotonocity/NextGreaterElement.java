package Monotonocity;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n]; // Output array
        Arrays.fill(result, -1);   // Default to -1 if no greater element exists
        Stack<Integer> stack = new Stack<>(); // Stack stores indices

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // While stack is not empty and current element is greater than stack top element
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) { //If this condition is true, it means we have found the next greater element (NGE) for the element at the index stored at the top of the stack.
                int index = stack.pop(); // Pop the top index
                result[index] = nums[i]; // Assign the NGE to current element
            }
            stack.push(i); // Push the current index onto the stack. If nums[i] is smaller than nums[stack.peek()], we push 𝑖 it means we are pushing smaller indices in stack that's why it is monotonic decreasing stack
            
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};      //Next Greater Elements: [4, 4, 5, 5, -1]
        int[] nge = nextGreaterElement(nums);

        System.out.println("Next Greater Elements:");
        System.out.println(Arrays.toString(nge));
    }
}

/*Mathematical Process
For any given sequence nums, let's say we iterate through the array and maintain our stack. Suppose:

Push condition: If nums[i] is smaller than nums[stack.peek()], we push 
Pop condition: If nums[i] is greater than nums[stack.peek()], then: 
We pop from the stack until nums[i]≤nums[stack.peek()].
This guarantees that the stack always holds indices of decreasing elements.

Thus, the stack maintains the monotonic decreasing property for stored values.

 */