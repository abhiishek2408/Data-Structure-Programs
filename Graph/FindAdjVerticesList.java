package Graph;

import java.util.*;

public class FindAdjVerticesList {
    private List<List<Integer>> adjList;

    public FindAdjVerticesList(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize adjacency lists
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        if (u >= 0 && u < adjList.size() && v >= 0 && v < adjList.size()) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // Undirected graph
        } else {
            System.out.println("Invalid edge: (" + u + ", " + v + ")");
        }
    }

    // Find all adjacent vertices of u
    public List<Integer> getAdjacentVertices(int u) {
        if (u >= 0 && u < adjList.size()) {
            return adjList.get(u);
        } else {
            System.out.println("Invalid vertex: " + u);
            return Collections.emptyList(); // Return empty list for invalid vertex
        }
    }

    // Print adjacency list
    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FindAdjVerticesList graph = new FindAdjVerticesList(5); // Start with 5 vertices

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

        // Get adjacent vertices
        System.out.print("Enter a vertex to find its adjacent vertices: ");
        int u = scanner.nextInt();
        List<Integer> adjacent = graph.getAdjacentVertices(u);

        System.out.println("Adjacent vertices of " + u + ": " + adjacent);

        scanner.close();
    }
}
