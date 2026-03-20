package Graph;

import java.util.*;

public class AddRemoveListEdgeUnDirected {
    private List<List<Integer>> adjList;

    public AddRemoveListEdgeUnDirected(int vertices) {
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

    // Remove an edge
    public void removeEdge(int u, int v) {
        if (u >= 0 && u < adjList.size() && v >= 0 && v < adjList.size()) {
            adjList.get(u).remove(Integer.valueOf(v));
            adjList.get(v).remove(Integer.valueOf(u)); // Remove both ways
        } else {
            System.out.println("Invalid edge: (" + u + ", " + v + ")");
        }
    }

    // Add a new vertex
    public void addVertex() {
        adjList.add(new ArrayList<>());
        System.out.println("Vertex " + (adjList.size() - 1) + " added.");
    }

    // Remove a vertex
    public void removeVertex(int v) {
        if (v < 0 || v >= adjList.size()) {
            System.out.println("Invalid vertex: " + v);
            return;
        }

        // Remove edges associated with this vertex
        for (List<Integer> neighbors : adjList) {
            neighbors.remove(Integer.valueOf(v));
        }

        adjList.remove(v); // Remove vertex

        // Adjust remaining vertex indices
        for (List<Integer> neighbors : adjList) {
            for (int i = 0; i < neighbors.size(); i++) {
                if (neighbors.get(i) > v) {
                    neighbors.set(i, neighbors.get(i) - 1);
                }
            }
        }

        System.out.println("Vertex " + v + " removed.");
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
        AddRemoveListEdgeUnDirected graph = new AddRemoveListEdgeUnDirected(3); // Start with 3 vertices

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.printGraph();

        // Add a vertex
        graph.addVertex();
        graph.printGraph();

        // Remove a vertex
        System.out.print("Enter vertex to remove: ");
        int v = scanner.nextInt();
        graph.removeVertex(v);
        graph.printGraph();

        scanner.close();
    }
}

