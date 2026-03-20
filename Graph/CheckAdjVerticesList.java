package Graph;

import java.util.*;

public class CheckAdjVerticesList {

    private List<List<Integer>> adjList;

    public CheckAdjVerticesList(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        if (u >= 0 && u < adjList.size() && v >= 0 && v < adjList.size()) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        } else {
            System.out.println("Invalid edge: (" + u + ", " + v + ")");
        }
    }

    // Check if u and v are adjacent
    public boolean areAdjacent(int u, int v) {
        if (u >= 0 && u < adjList.size() && v >= 0 && v < adjList.size()) {
            return adjList.get(u).contains(v);
        }
        return false; // Invalid vertex
    }

    // Print adjacency list
    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> " + adjList.get(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckAdjVerticesList graph = new CheckAdjVerticesList(4); // Start with 4 vertices

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.printGraph();

        // Check adjacency
        System.out.print("Enter two vertices to check adjacency: ");
        int u = scanner.nextInt();
        int v = scanner.nextInt();
        
        if (graph.areAdjacent(u, v)) {
            System.out.println(u + " and " + v + " are adjacent.");
        } else {
            System.out.println(u + " and " + v + " are NOT adjacent.");
        }

        scanner.close();
    }
}

