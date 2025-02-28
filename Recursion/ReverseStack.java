package Recursion;

import java.util.*;

public class ReverseStack {

    // Function to reverse the stack using recursion
    public static void reverse(Stack<Integer> stack) {
        // Base case: if stack is empty, do nothing
        if (stack.isEmpty()) {
            return;
        }
        
        // Step 1: Pop the top element
        int top = stack.pop();
        
        // Step 2: Reverse the remaining stack
        reverse(stack);
        
        // Step 3: Insert the popped element at the bottom of the stack
        insertAtBottom(stack, top);
    }

    // Helper function to insert an element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> stack, int element) {
        // Base case: if the stack is empty, push the element
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            // Step 1: Pop the top element
            int top = stack.pop();
            
            // Step 2: Recursively call insertAtBottom for the remaining stack
            insertAtBottom(stack, element);
            
            // Step 3: Push the popped element back on the stack
            stack.push(top);
        }
    }

    // Main function to test the reverse stack function
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // Push some elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        
        System.out.println("Original Stack: " + stack);
        
        // Reverse the stack
        reverse(stack);
        
        System.out.println("Reversed Stack: " + stack);
    }
}

