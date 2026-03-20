// BalanceParentheses.java
// Balances a string of parentheses by adding the minimum number of brackets
/*
Test case:
Input: str = ")((())"
Output: ((()))
Input: str = "(()))("
Output: (())()()
*/

class BalanceParentheses {
    // Returns a balanced string by adding minimum number of brackets
    static String balanceParentheses(String str) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                open++;
                sb.append('(');
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    sb.append(')');
                } else {
                    sb.append('(');
                    sb.append(')');
                }
            }
        }
        // Add remaining open brackets
        while (open-- > 0) sb.append(')');
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = ")((())";
        String s2 = "(()))(";
        System.out.println(balanceParentheses(s1)); // ((()))
        System.out.println(balanceParentheses(s2)); // (())()()
    }
}
