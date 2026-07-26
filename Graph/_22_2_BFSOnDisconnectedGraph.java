package Graph;
import java.util.*;

public class _22_2_BFSOnDisconnectedGraph {

    // BFS Function
    static void bfs(int start, ArrayList<ArrayList<Integer>> graph,
                    boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Component 1
        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        // Component 2
        graph.get(3).add(4);
        graph.get(4).add(3);

        boolean[] visited = new boolean[V];

        // BFS for all components
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                bfs(i, graph, visited);
            }
        }
    }
}
