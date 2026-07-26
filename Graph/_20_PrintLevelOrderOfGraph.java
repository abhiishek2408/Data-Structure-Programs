package Graph;

import java.util.*;

public class _20_PrintLevelOrderOfGraph {
    
    // Function to print the level order traversal of a graph
    public static void printLevelOrder(ArrayList<ArrayList<Integer>> adj, int startNode, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        // Start from the source node
        queue.add(startNode);
        visited[startNode] = true;
        
        int level = 0;
        
        System.out.println("Level Order Traversal:");
        
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int size = queue.size();
            System.out.print("Level " + level + ": ");
            
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                System.out.print(curr + " ");
                
                // Add unvisited neighbors to the queue
                for (int neighbor : adj.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println(); // Move to the next line for the next level
            level++;
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Creating a sample graph
        //      0
        //    /   \
        //   1     2
        //  / \   / \
        // 3   4 5   6
        
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(0).add(2); adj.get(2).add(0);
        
        adj.get(1).add(3); adj.get(3).add(1);
        adj.get(1).add(4); adj.get(4).add(1);
        
        adj.get(2).add(5); adj.get(5).add(2);
        adj.get(2).add(6); adj.get(6).add(2);
        
        printLevelOrder(adj, 0, V);
    }
}

