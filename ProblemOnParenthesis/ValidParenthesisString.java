// ValidParenthesisString.java
// Checks if a string containing '(', ')', and '*' is a valid parenthesis string
/*
Test case:
Input: s = "(*)"
Output: true
Input: s = "(*))"
Output: true
Input: s = "(*()"
Output: true
Input: s = "(*)))"
Output: false
*/

class ValidParenthesisString {
    // Returns true if the string is a valid parenthesis string
    static boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else if (ch == '*') {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) return false;
            if (minOpen < 0) minOpen = 0;
        }
        return minOpen == 0;
    }

    public static void main(String[] args) {
        String s1 = "(*)";
        String s2 = "(*))";
        String s3 = "(*()";
        String s4 = "(*)))";
        System.out.println(checkValidString(s1)); // true
        System.out.println(checkValidString(s2)); // true
        System.out.println(checkValidString(s3)); // true
        System.out.println(checkValidString(s4)); // false
    }
}
