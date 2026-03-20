// ValidParentheses.java
// Checks if a string of parentheses (and brackets) is valid (balanced and properly nested)
/*
Test case:
Input: str = "()[]{}"
Output: true
Input: str = "([)]"
Output: false
Input: str = "{[]}"
Output: true
*/

import java.util.Stack;

class ValidParentheses {
    // Returns true if the string is valid (balanced and properly nested)
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";
        String s3 = "{[]}";
        System.out.println(isValid(s1)); // true
        System.out.println(isValid(s2)); // false
        System.out.println(isValid(s3)); // true
    }
}
