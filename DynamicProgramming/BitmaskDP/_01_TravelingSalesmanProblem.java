package DynamicProgramming.BitmaskDP;
public class _01_TravelingSalesmanProblem {
    public int tsp(int[][] graph) {
        int n = graph.length;
        int VISITED_ALL = (1 << n) - 1;
        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) java.util.Arrays.fill(dp[i], -1);
        return tspHelper(1, 0, VISITED_ALL, graph, dp);
    }
    private int tspHelper(int mask, int pos, int VISITED_ALL, int[][] graph, int[][] dp) {
        if (mask == VISITED_ALL) return graph[pos][0];
        if (dp[mask][pos] != -1) return dp[mask][pos];
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < graph.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = graph[pos][city] + tspHelper(mask | (1 << city), city, VISITED_ALL, graph, dp);
                ans = Math.min(ans, newAns);
            }
        }
        return dp[mask][pos] = ans;
    }
}