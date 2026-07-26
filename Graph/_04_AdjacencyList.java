package Graph;

import java.util.ArrayList;

/**
 * Adjacency List representation of a Graph.
 * An adjacency list is an array (or list) of lists where each index i represents a vertex,
 * and the list at index i contains all the vertices connected to i by an edge.
 */
public class _04_AdjacencyList {
    private ArrayList<ArrayList<Integer>> adjList;
    private int numVertices;

    // Constructor to initialize the graph with a fixed number of vertices
    public _04_AdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    // Add an edge (Undirected Graph)
    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjList.get(source).add(destination);
            adjList.get(destination).add(source); // Symmetric for undirected graph
        } else {
            System.out.println("Invalid vertices range: " + source + " - " + destination);
        }
    }

    // Remove an edge
    public void removeEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            // Remove destination from source's list
            adjList.get(source).remove(Integer.valueOf(destination));
            // Remove source from destination's list
            adjList.get(destination).remove(Integer.valueOf(source));
        } else {
            System.out.println("Invalid vertices range: " + source + " - " + destination);
        }
    }

    // Check if an edge exists between two vertices
    public boolean hasEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            return adjList.get(source).contains(destination);
        }
        return false;
    }

    // Print the adjacency list
    public void printGraph() {
        System.out.println("Adjacency List representation of Graph:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " -> ");
            ArrayList<Integer> list = adjList.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + (j < list.size() - 1 ? " -> " : ""));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices (numbered 0 to 4)
        int vertices = 5;
        _04_AdjacencyList graph = new _04_AdjacencyList(vertices);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the graph representation
        graph.printGraph();

        // Check if specific edges exist
        System.out.println("\nIs there an edge between 1 and 2? " + graph.hasEdge(1, 2));
        System.out.println("Is there an edge between 0 and 2? " + graph.hasEdge(0, 2));

        // Remove an edge and print again
        System.out.println("\nRemoving edge (1, 3)...");
        graph.removeEdge(1, 3);
        graph.printGraph();
    }
}
