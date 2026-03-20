package Graph;

import java.util.*;

class CycleDetectionDirected {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    // Constructor
    CycleDetectionDirected(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }

    // Function to add a directed edge to the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w); // Directed edge v -> w
    }

    // DFS utility function for cycle detection
    boolean isCyclicUtil(int v, boolean visited[], boolean recStack[]) {
        if (recStack[v]) // Node is already in recursion stack → Cycle detected
            return true;
        if (visited[v]) // If already visited and not in stack, no cycle
            return false;

        visited[v] = true;
        recStack[v] = true; // Mark current node in recursion stack

        for (int neighbor : adj.get(v)) {
            if (isCyclicUtil(neighbor, visited, recStack))
                return true;
        }

        recStack[v] = false; // Remove from recursion stack before backtracking
        return false;
    }

    // Function to detect cycle in a directed graph
    boolean isCyclic() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recStack))
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        CycleDetectionDirected g = new CycleDetectionDirected(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1); // This creates a cycle

        if (g.isCyclic())
            System.out.println("Graph contains a cycle");
        else
            System.out.println("Graph does not contain a cycle");
    }
}

