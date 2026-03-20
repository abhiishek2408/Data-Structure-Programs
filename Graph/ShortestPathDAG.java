package Graph;

import java.util.*;

class ShortestPathDAG {
    
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void topologicalSort(int node, boolean[] visited, Stack<Integer> stack, List<List<Edge>> adj) {
        visited[node] = true;
        for (Edge edge : adj.get(node)) {
            if (!visited[edge.dest]) {
                topologicalSort(edge.dest, visited, stack, adj);
            }
        }
        stack.push(node);
    }

    static int[] shortestPath(int V, List<List<Edge>> adj, int source) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Topological Sort
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adj);
            }
        }

        // Step 2: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Step 3: Relax edges in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge edge : adj.get(u)) {
                    int v = edge.dest;
                    int weight = edge.weight;
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }
        
        return dist;
    }

    public static void main(String[] args) {
        int V = 6;  // Number of vertices
        List<List<Edge>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (u -> v, weight)
        adj.get(0).add(new Edge(1, 2));
        adj.get(0).add(new Edge(4, 1));
        adj.get(1).add(new Edge(2, 3));
        adj.get(4).add(new Edge(2, 2));
        adj.get(4).add(new Edge(5, 4));
        adj.get(2).add(new Edge(3, 6));
        adj.get(5).add(new Edge(3, 1));

        int source = 0;
        int[] result = shortestPath(V, adj, source);

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " : " + (result[i] == Integer.MAX_VALUE ? "INF" : result[i]));
        }
    }
}

