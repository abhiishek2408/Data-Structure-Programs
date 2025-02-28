import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            
            if (x == '(' || x == '{' || x == '[') {
                s.push(x);
            } else {
                if (s.isEmpty()) {
                    return false;
                } 
                else if (!matching(s.peek(), x)) {
                    return false;
                } 
                else {
                    s.pop();
                }
            }
        }
        
        return s.isEmpty();
    }

    public static boolean matching(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        } else if (open == '{' && close == '}') {
            return true;
        } else if (open == '[' && close == ']') {
            return true;
        }
        return false;
    }    
    
    public static void main(String[] args) {
        String test1 = "({[]})";
        String test2 = "({[})";
        String test3 = "((()))";

        System.out.println(isBalanced(test1)); // true
        System.out.println(isBalanced(test2)); // false
        System.out.println(isBalanced(test3)); // true
    }
}
