package String;

public class ValidParenthesesI {

    public boolean checkValidString(String s) {
        int open = 0, close = 0;
        int n = s.length();
        
        // Forward pass: treat '*' as '('
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                open++;
            } else {
                open--;
            }
            if (open < 0) return false;
        }
        
        // Backward pass: treat '*' as ')'
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                close++;
            } else {
                close--;
            }
            if (close < 0) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ValidParenthesesI solution = new ValidParenthesesI();
        System.out.println(solution.checkValidString("(*)")); // Output: true
        System.out.println(solution.checkValidString("(*))")); // Output: true
        System.out.println(solution.checkValidString("(((**)")); // Output: true
        System.out.println(solution.checkValidString("(((")); // Output: false
    }
}
