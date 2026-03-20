package Graph;

import java.util.*;

class CycleDetectionUndirected {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    // Constructor
    CycleDetectionUndirected(int v) {
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

    // Helper function for DFS-based cycle detection
    boolean isCyclicUtil(int v, boolean visited[], int parent) {
        visited[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, v))
                    return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Function to detect cycle in an undirected graph
    boolean isCyclic() {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1))
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        CycleDetectionUndirected g = new CycleDetectionUndirected(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1); // This edge creates a cycle

        if (g.isCyclic())
            System.out.println("Graph contains a cycle");
        else
            System.out.println("Graph does not contain a cycle");
    }
}
