package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAdjVerticesMatrix {
    private int[][] adjMatrix;
    private int vertices;

    public FindAdjVerticesMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Add a directed edge (one-way connection)
    public void addEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = 1; // Directed edge from src -> dest
        } else {
            System.out.println("Invalid edge: (" + src + ", " + dest + ")");
        }
    }

    // Find all vertices adjacent to u
    public List<Integer> getAdjacentVertices(int u) {
        List<Integer> adjacentVertices = new ArrayList<>();
        if (u >= 0 && u < vertices) {
            for (int v = 0; v < vertices; v++) {
                if (adjMatrix[u][v] == 1) {
                    adjacentVertices.add(v);
                }
            }
        }
        return adjacentVertices;
    }

    // Print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        FindAdjVerticesMatrix graph = new FindAdjVerticesMatrix(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        graph.printGraph();

        // Find adjacent vertices of a given node
        System.out.print("Enter a vertex to find its adjacent vertices: ");
        int u = scanner.nextInt();

        List<Integer> adjacent = graph.getAdjacentVertices(u);
        if (adjacent.isEmpty()) {
            System.out.println("Vertex " + u + " has no adjacent vertices.");
        } else {
            System.out.println("Vertices adjacent to " + u + ": " + adjacent);
        }

        scanner.close();
    }
}

