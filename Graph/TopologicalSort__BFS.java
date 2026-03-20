package Graph;

import java.util.*;

class TopologicalSort__BFS {
    
    // Function to perform topological sort using Kahn's Algorithm
    public static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V]; // Array to store in-degree of nodes
        
        // Calculate in-degree of each node
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all nodes with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> topOrder = new ArrayList<>();
        
        // Process nodes in BFS manner
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topOrder.add(node);
            
            // Reduce in-degree of all adjacent nodes
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Check for cycle (if topOrder doesn't contain all nodes)
        if (topOrder.size() != V) {
            throw new RuntimeException("Graph has a cycle! Topological sorting is not possible.");
        }
        
        return topOrder;
    }
    
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Example directed acyclic graph (DAG)
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        List<Integer> topologicalOrder = topologicalSort(V, adj);
        System.out.println("Topological Order: " + topologicalOrder);
    }
}

