package DynamicProgramming.DigitDP;
public class _04_DigitDPSumProblems {
    // Boilerplate for generic Digit DP
    // Problem: Find sum of digits of all numbers from L to R
    Long[][][] dp = new Long[20][180][2];
    public long sumOfDigits(long l, long r) {
        return solve(r) - solve(l - 1);
    }
    private long solve(long x) {
        if (x < 0) return 0;
        String s = String.valueOf(x);
        dp = new Long[20][180][2];
        return dfs(s, 0, 0, 1);
    }
    private long dfs(String s, int pos, int sum, int tight) {
        if (pos == s.length()) return sum;
        if (dp[pos][sum][tight] != null) return dp[pos][sum][tight];
        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;
        long res = 0;
        for (int i = 0; i <= limit; i++) {
            res += dfs(s, pos + 1, sum + i, (tight == 1 && i == limit) ? 1 : 0);
        }
        return dp[pos][sum][tight] = res;
    }
}