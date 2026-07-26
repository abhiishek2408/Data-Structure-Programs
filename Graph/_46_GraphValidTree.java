package Graph;

import java.util.*;

public class _46_GraphValidTree {

    static boolean validTree(int n, int[][] edges) {

        // Tree must have n-1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build graph
        ArrayList<ArrayList<Integer>> graph =
            new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited =
            new boolean[n];

        Queue<Integer> queue =
            new LinkedList<>();

        queue.add(0);

        visited[0] = true;

        // BFS
        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbor :
                 graph.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.add(neighbor);
                }
            }
        }

        // Check connected
        for (boolean v : visited) {

            if (!v) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
            {0,1},
            {0,2},
            {0,3},
            {1,4}
        };

        System.out.println(
            validTree(n, edges)
        );
    }
}
