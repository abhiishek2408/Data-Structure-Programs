package String;

public class _29_MinReversalsToBalanceParentheses {
    public int countMinReversals(String s) {
        if (s.length() % 2 != 0) return -1;

        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '{') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        // Result is ceil(open/2) + ceil(close/2)
        return (int) (Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
    }

    public static void main(String[] args) {
        _29_MinReversalsToBalanceParentheses sol = new _29_MinReversalsToBalanceParentheses();
        String s = "}{{}}{{{";
        System.out.println("Min reversals for " + s + ": " + sol.countMinReversals(s));
    }
}
