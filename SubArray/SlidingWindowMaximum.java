
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

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            
            deque.offerLast(i);

            // Once we have a complete window, set the result
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
