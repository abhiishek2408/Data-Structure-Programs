package Graph;

import java.util.*;

class BFSConnectedSource {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    // Constructor
    @SuppressWarnings("unchecked")
    public BFSConnectedSource(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Assuming an undirected graph
    }

    // BFS traversal from multiple connected sources
    public void BFS(List<Integer> sources) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize queue with source nodes
        for (int src : sources) {
            if (!visited[src]) {
                queue.add(src);
                visited[src] = true;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        BFSConnectedSource g = new BFSConnectedSource(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        
        List<Integer> sources = Arrays.asList(0, 2); // Multiple connected sources
        System.out.println("BFS Traversal:");
        g.BFS(sources);
    }
}

