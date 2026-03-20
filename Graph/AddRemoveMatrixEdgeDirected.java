package Graph;

import java.util.Scanner;

public class AddRemoveMatrixEdgeDirected {

    private int[][] adjMatrix;
    private int vertices;

    public AddRemoveMatrixEdgeDirected(int vertices) {
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

    // Remove a directed edge (one-way disconnection)
    public void removeEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = 0;
        } else {
            System.out.println("Invalid edge: (" + src + ", " + dest + ")");
        }
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
        AddRemoveMatrixEdgeDirected graph = new AddRemoveMatrixEdgeDirected(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        graph.printGraph();
        scanner.close();
    }
}


