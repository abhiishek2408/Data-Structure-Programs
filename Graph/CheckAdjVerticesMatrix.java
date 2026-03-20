package Graph;

import java.util.Scanner;

public class CheckAdjVerticesMatrix {
    private int[][] adjMatrix;
    private int vertices;

    public CheckAdjVerticesMatrix(int vertices) {
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

    // Check if u and v are adjacent
    public boolean isAdjacent(int u, int v) {
        if (u >= 0 && u < vertices && v >= 0 && v < vertices) {
            return adjMatrix[u][v] == 1;
        }
        return false; // Invalid indices, return false
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
        CheckAdjVerticesMatrix graph = new CheckAdjVerticesMatrix(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        graph.printGraph();

        // Check adjacency between two vertices
        System.out.print("Enter two vertices to check adjacency (u v): ");
        int u = scanner.nextInt();
        int v = scanner.nextInt();

        if (graph.isAdjacent(u, v)) {
            System.out.println("Yes, " + u + " and " + v + " are adjacent.");
        } else {
            System.out.println("No, " + u + " and " + v + " are not adjacent.");
        }

        scanner.close();
    }
}


