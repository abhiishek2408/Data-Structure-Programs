package String;

import java.util.ArrayList;
import java.util.List;

public class _19_GenerateParetheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        _19_GenerateParetheses solution = new _19_GenerateParetheses();
        int n = 3;
        System.out.println("Generated Parentheses: " + solution.generateParenthesis(n));
    }
}


