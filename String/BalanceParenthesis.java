package String;

import java.util.Stack;

public class BalanceParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == ']' && top != '[') || 
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalanceParenthesis solution = new BalanceParenthesis();
        
        // Test cases
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        for (String test : testCases) {
            System.out.println("Input: " + test + " -> Output: " + solution.isValid(test));
        }
    }
}

