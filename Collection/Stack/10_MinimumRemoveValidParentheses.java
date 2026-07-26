package Collection.Stack;

import java.util.*;

public class MinimumRemoveValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // First pass: remove unmatched ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i); // unmatched ')'
                } else {
                    stack.pop(); // matched '('
                }
            }
        }

        // Remaining unmatched '(' in stack
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        // Build the result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    // Example usage
    public static void main(String[] args) {
        MinimumRemoveValidParentheses obj = new MinimumRemoveValidParentheses();
        String input = "a)b(c)d";
        String output = obj.minRemoveToMakeValid(input);
        System.out.println("Output: " + output);  // Output: "ab(c)d"
    }
}

