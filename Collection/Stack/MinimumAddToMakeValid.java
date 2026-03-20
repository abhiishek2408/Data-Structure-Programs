package Collection.Stack;

public class MinimumAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int open = 0; // unmatched opening '('
        int add = 0;  // parentheses to add

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--; // matched with a previous '('
                } else {
                    add++; // unmatched ')', need an extra '('
                }
            }
        }

        // add all unmatched '(' + unmatched ')'
        return open + add;
    }

    // Example usage
    public static void main(String[] args) {
        MinimumAddToMakeValid obj = new MinimumAddToMakeValid();
        String input = "())";
        int result = obj.minAddToMakeValid(input);
        System.out.println("Output: " + result);  // Output: 1
    }
}
