// MinRemoveToMakeValidParentheses.java
// Removes the minimum number of parentheses to make the string valid
/*
Test case:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Input: s = ")a)b(c)d("
Output: "ab(c)d"
Input: s = "a)b(c)d"
Output: "ab(c)d"
*/

import java.util.Stack;

class MinRemoveToMakeValidParentheses {
    // Returns a valid string by removing the minimum number of parentheses
    static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] remove = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    remove[i] = true;
                }
            }
        }
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "lee(t(c)o)de)";
        String s2 = ")a)b(c)d(";
        String s3 = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s1)); // lee(t(c)o)de
        System.out.println(minRemoveToMakeValid(s2)); // ab(c)d
        System.out.println(minRemoveToMakeValid(s3)); // ab(c)d
    }
}
