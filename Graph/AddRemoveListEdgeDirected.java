package Graph;

import java.util.*;

class AddRemoveListEdgeDirected {
    private List<List<Integer>> adjList; // Adjacency list

    public AddRemoveListEdgeDirected(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize empty lists for each vertex
        }
    }

    // Add a directed edge from u to v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    // Remove a directed edge from u to v
    public void removeEdge(int u, int v) {
        adjList.get(u).remove(Integer.valueOf(v)); // Remove v from u’s adjacency list
    }

    // Display the adjacency list
    public void display() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
    }

    public static void main(String[] args) {
        AddRemoveListEdgeDirected graph = new AddRemoveListEdgeDirected(5); // Creating a graph with 5 vertices

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        System.out.println("Graph:");
        graph.display();

        System.out.println("\nRemoving edge (0 -> 2)...\n");
        graph.removeEdge(0, 2);
        graph.display();
    }
}

