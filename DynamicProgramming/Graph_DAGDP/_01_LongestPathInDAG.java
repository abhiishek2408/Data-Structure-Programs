package DynamicProgramming.Graph_DAGDP;
import java.util.*;
public class _01_LongestPathInDAG {
    public int longestPath(int V, ArrayList<ArrayList<int[]>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[src] = 0;
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) if (!visited[i]) topoSort(i, visited, stack, adj);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MIN_VALUE) {
                for (int[] edge : adj.get(u)) {
                    int v = edge[0], weight = edge[1];
                    if (dist[v] < dist[u] + weight) dist[v] = dist[u] + weight;
                }
            }
        }
        int max = 0;
        for (int d : dist) max = Math.max(max, d);
        return max;
    }
    private void topoSort(int v, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<int[]>> adj) {
        visited[v] = true;
        for (int[] edge : adj.get(v)) {
            if (!visited[edge[0]]) topoSort(edge[0], visited, stack, adj);
        }
        stack.push(v);
    }
}