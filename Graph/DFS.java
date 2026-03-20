package Graph;

import java.util.*;

class DFS {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor
    @SuppressWarnings("unchecked")
    DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v’s list
        adj[w].add(v); // Since the graph is connected, add v to w's list as well
    }

    // DFS traversal from a given source
    void DFSRecu(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSRecu(n, visited);
            }
        }
    }

    // Wrapper function for DFS traversal
    void DFSs(int source) {
        boolean visited[] = new boolean[V];
        DFSRecu(source, visited);
    }

    public static void main(String args[]) {
        DFS g = new DFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("Depth-First Search starting from vertex 0:");
        g.DFSs(0);
    }
}

