// MinReversalsToBalanceParentheses.java
// Finds the minimum number of reversals to balance a string of parentheses
/*
Test case:
Input: str = ")((())"
Output: 2
Explanation: Reverse first and last bracket to get balanced string "((()))"
Input: str = ")((()"
Output: -1 (odd length, cannot be balanced)
*/

class MinReversalsToBalanceParentheses {
    // Returns the minimum number of reversals to balance the parentheses, or -1 if not possible
    static int minReversals(String str) {
        int n = str.length();
        if (n % 2 != 0) return -1; // Odd length cannot be balanced
        int open = 0, close = 0;
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) open--;
                else close++;
            }
        }
        // (open + 1) / 2 reversals for open, (close + 1) / 2 for close
        return (open + 1) / 2 + (close + 1) / 2;
    }

    public static void main(String[] args) {
        String s1 = ")((())";
        String s2 = ")((()";
        System.out.println(minReversals(s1)); // 2
        System.out.println(minReversals(s2)); // -1
    }
}
