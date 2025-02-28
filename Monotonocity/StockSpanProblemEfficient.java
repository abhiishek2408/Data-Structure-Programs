package Monotonocity;

import java.util.Stack;

class StockSpanProblemEfficient {

    // Stack to store pairs of (price, span)
    private Stack<int[]> stack;

    public StockSpanProblemEfficient() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        // While the current price is greater than or equal to the price on top of the stack
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        System.out.println("Span = "+span + " \n"); // Output: 1
        System.out.print("Stack elements:");
        for (int[] arr : stack) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        // Push the current price and its span onto the stack
        stack.push(new int[]{price, span});
        return span;
    }

 public static void main(String[] args) {
        StockSpanProblemEfficient stockSpanner = new StockSpanProblemEfficient();
        System.out.println("Span of each element are: \n"); // Output: 1
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}

