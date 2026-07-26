package Graph;
import java.util.*;

public class _33_ShortestPathBFS {

    static void shortestPath(int src,
                             ArrayList<ArrayList<Integer>> graph,
                             int V) {

        boolean[] visited = new boolean[V];

        int[] dist = new int[V];

        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        dist[src] = 0;

        queue.add(src);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    dist[neighbor] = dist[node] + 1;

                    queue.add(neighbor);
                }
            }
        }

        // Print shortest distances
        for (int i = 0; i < V; i++) {

            System.out.println(
                "Distance from " + src +
                " to " + i +
                " = " + dist[i]
            );
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected graph
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(0).add(2);
        graph.get(2).add(0);

        graph.get(1).add(3);
        graph.get(3).add(1);

        graph.get(2).add(4);
        graph.get(4).add(2);

        shortestPath(0, graph, V);
    }
}
