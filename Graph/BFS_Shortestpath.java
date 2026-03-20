package Graph;

import java.util.*;

class BFS_ShortestPath {
    private int V; 
    private List<List<Integer>> adj;

    // Constructor
    BFS_ShortestPath(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w); // Add w to v’s list
        adj.get(w).add(v); // Since the graph is undirected, add v to w's list as well
    }

    // BFS for shortest path in an unweighted graph
    void shortestPath(int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        
        dist[source] = 0;
        queue.add(source);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        // Print shortest distance from source
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " -> Distance: " + dist[i]);
        }
    }

    public static void main(String args[]) {
        BFS_ShortestPath g = new BFS_ShortestPath(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("Shortest Path in Unweighted Graph:");
        g.shortestPath(0);
    }
}
