package Monotonocity;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {
    public static void findPreviousGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Fill result array with -1 initially
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 20, 40, 12, 30};  //Output: -1 10 4 -1 -1 40 40

        findPreviousGreater(arr);
    }
}
