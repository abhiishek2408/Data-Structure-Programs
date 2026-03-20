package Graph;

import java.util.*;

public class BFSConnectedDisconnected {
    private int V; // Number of vertices
    private ArrayList<ArrayList<Integer>> adj; // Adjacency List

    // Constructor
    public BFSConnectedDisconnected(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge to the graph
    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v); // Assuming an undirected graph
    }

    // BFS traversal from a given source node
    public void BFS(int s, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    // BFS traversal for a disconnected graph
    public void BFSD() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                BFS(i, visited);
                System.out.println(); // Separate components
            }
        }
    }

    public static void main(String args[]) {
        BFSConnectedDisconnected g = new BFSConnectedDisconnected(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        System.out.println("BFS Traversal of the graph:");
        g.BFSD(); // Handles both connected and disconnected graphs
    }
}