package Graph;

import java.util.*;

public class BFSDisConnectedSource {

    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    // Constructor
    @SuppressWarnings("unchecked")
    public BFSDisConnectedSource(int v) {
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

    // BFS traversal from multiple unconnected sources
    public void BFS(List<Integer> sources) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int src : sources) {
            if (!visited[src]) {
                queue.add(src);
                visited[src] = true;
                
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
                System.out.println(); // Separate components
            }
        }
    }

    public static void main(String args[]) {
        BFSDisConnectedSource g = new BFSDisConnectedSource(6);
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        
        List<Integer> sources = Arrays.asList(0, 2, 4); // Multiple unconnected sources
        System.out.println("BFS Traversal:");
        g.BFS(sources);
    }
}


