package String;

public class ValidParentheses {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false; // Odd length cannot be valid
        
        int open = 0, close = 0;
        // Forward pass to check '(' balance
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                open++;
            } else {
                close++;
            }
            if (close > open) return false;
        }
        
        open = 0;
        close = 0;
        // Backward pass to check ')' balance
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                close++;
            } else {
                open++;
            }
            if (open > close) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.canBeValid("))()))", "010100")); // Output: true
        System.out.println(solution.canBeValid("()()", "0000"));    // Output: true
        System.out.println(solution.canBeValid("(()))", "10001"));  // Output: false
    }
}


