
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    
    // Efficient sliding window approach using deque
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {  // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements from the back that are smaller than current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) { 
                deque.pollLast();
            }

             // Add current element index to the deque
            deque.offerLast(i);

            // Store the maximum element for the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // Naive approach (inefficient)
    public static int[] maxSlidingWindowNaive(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];  // To store the result for each window

        // Process each sliding window
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            
            // Find the maximum in the current window
            for (int j = 1; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            
            // Store the maximum of the current window
            result[i] = max;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = new int[]{2, 6, 4, 8, 1};
        int k = 3;

        System.out.print("Original Array: ");
        for (int i : result) {
            System.out.print(i+" ");
        }
        System.out.println();

        // Testing the optimized sliding window
        int[] arr = maxSlidingWindow(result, k);
        System.out.print("Optimized Sliding Window: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        
        // Testing the naive approach
        int[] arr1 = maxSlidingWindowNaive(result, k);
        System.out.print("Naive Sliding Window: ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}


/*maxSlidingWindow Method:

Uses a deque to store indices of elements in a monotonic decreasing order.
Removes out-of-bounds indices from the deque.
Removes smaller elements from the back before inserting a new one.
The front of the deque always holds the max element's index.
main Method:

Creates an instance of Solution.
Initializes nums = {1, 3, -1, -3, 5, 3, 6, 7} and k = 3.
Calls maxSlidingWindow and prints the result. 


In the Sliding Window Maximum problem, we are given an array and a window size k. As we 
slide the window from left to right, some elements move out of the window. These elements 
should be removed from the deque because they are no longer relevant for finding the maximum.
*/




/*The Sliding Window Maximum problem is a data structure and algorithm problem commonly 
asked in technical interviews. It falls under the following categories:

1. Sliding Window Technique
The problem requires finding the maximum in every contiguous subarray of size k.
We move a "window" of size k across the array and update the maximum efficiently.
2. Deque (Double-Ended Queue) Usage
Instead of recalculating the max in each window (O(k) per window), we use a deque to maintain indices of potential maximum values.
This ensures an O(n) solution.
3. Monotonic Data Structure
The deque maintains elements in decreasing order.
This helps efficiently remove unnecessary elements and always keep the max at the front.
 */