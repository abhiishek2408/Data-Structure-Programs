package Collection.Stack;
import java.util.Stack;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String str) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int start = 0; 

        System.out.println("Input: " + str);
        System.out.println("Iteration logs:");

        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);

            
            if (x == '(') {
                st.push(x);
            } else {
                
                st.pop();
            }

            
            System.out.println("Index: " + i + ", Char: " + x + ", Stack Size: " + st.size());

            
            if (st.isEmpty()) {
                
                String part = str.substring(start + 1, i); 
                ans.append(part);

                
                System.out.println("  Primitive group found: " + str.substring(start, i + 1));
                System.out.println("  Added to result: " + part);
                System.out.println("  Current Result: " + ans);

                start = i + 1; 
            }
        }

        return ans.toString();
    }

    
    public static void main(String[] args) {
        RemoveOutermostParentheses solution = new RemoveOutermostParentheses();

        
        String input = "(()())(())(()(()))";
        String result = solution.removeOuterParentheses(input);

        System.out.println("\nFinal Result: " + result);
    }
}
