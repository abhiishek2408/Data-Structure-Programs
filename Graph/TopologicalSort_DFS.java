package Graph;

import java.util.*;

class TopologicalSort {
    
    // Function to perform topological sort using DFS
    public static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[node] = true;
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }
        
        stack.push(node);
    }
    
    public static List<Integer> topologicalSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }
        
        List<Integer> topOrder = new ArrayList<>();
        while (!stack.isEmpty()) {
            topOrder.add(stack.pop());
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

