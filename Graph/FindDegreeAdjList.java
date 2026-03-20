package Graph;

import java.util.*;

public class FindDegreeAdjList {

    private List<List<Integer>> adjList;

    public FindDegreeAdjList(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize adjacency lists
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        if (u >= 0 && u < adjList.size() && v >= 0 && v < adjList.size()) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // For undirected graph
        } else {
            System.out.println("Invalid edge: (" + u + ", " + v + ")");
        }
    }

    // Get the degree of a vertex
    public int getDegree(int v) {
        if (v >= 0 && v < adjList.size()) {
            return adjList.get(v).size();
        }
        return -1; // Invalid vertex
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
        AddRemoveListVertices graph = new AddRemoveListVertices(3); // Start with 3 vertices

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.printGraph();

        // Add a vertex
        graph.addVertex();
        graph.printGraph();
 
        graph.printGraph();

        scanner.close();
    }
}

