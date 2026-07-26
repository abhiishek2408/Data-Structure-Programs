package DynamicProgramming.BitmaskDP;
import java.util.*;
public class _04_ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;
        int finalState = (1 << n) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int node = curr[0], state = curr[1];
                if (state == finalState) return steps;
                for (int next : graph[node]) {
                    int nextState = state | (1 << next);
                    if (!visited[next][nextState]) {
                        visited[next][nextState] = true;
                        q.offer(new int[]{next, nextState});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}