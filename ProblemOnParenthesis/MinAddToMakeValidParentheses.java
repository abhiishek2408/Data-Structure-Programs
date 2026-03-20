// MinAddToMakeValidParentheses.java
// Finds the minimum number of parentheses to add to make the string valid
/*
Test case:
Input: s = "())"
Output: 1
Input: s = "(("
Output: 2
Input: s = "())((())"
Output: 3
*/

class MinAddToMakeValidParentheses {
    // Returns the minimum number of parentheses to add to make the string valid
    static int minAddToMakeValid(String s) {
        int open = 0, add = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open > 0) open--;
                else add++;
            }
        }
        return add + open;
    }

    public static void main(String[] args) {
        String s1 = ")())";
        String s2 = "((";
        String s3 = "())((())";
        System.out.println(minAddToMakeValid(s1)); // 1
        System.out.println(minAddToMakeValid(s2)); // 2
        System.out.println(minAddToMakeValid(s3)); // 3
    }
}
