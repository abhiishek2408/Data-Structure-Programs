package Graph;

import java.util.Scanner;

public class AddRemoveMatrixVertices {

    private int[][] adjMatrix;
    private int vertices;

    public AddRemoveMatrixVertices(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Add an undirected edge (both directions)
    public void addEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = 1;
            adjMatrix[dest][src] = 1; // Undirected edge
        } else {
            System.out.println("Invalid edge: (" + src + ", " + dest + ")");
        }
    }

    // Remove an edge
    public void removeEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = 0;
            adjMatrix[dest][src] = 0; // Undirected edge
        } else {
            System.out.println("Invalid edge: (" + src + ", " + dest + ")");
        }
    }

    // Add a new vertex (expand adjacency matrix)
    public void addVertex() {
        int newSize = vertices + 1;
        int[][] newMatrix = new int[newSize][newSize];

        // Copy old adjacency matrix to new matrix
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                newMatrix[i][j] = adjMatrix[i][j];
            }
        }

        this.vertices = newSize;
        this.adjMatrix = newMatrix;

        System.out.println("Vertex " + (newSize - 1) + " added.");
    }

    // Remove a vertex (shrink adjacency matrix)
    public void removeVertex(int vertex) {
        if (vertex < 0 || vertex >= vertices) {
            System.out.println("Invalid vertex: " + vertex);
            return;
        }

        int newSize = vertices - 1;
        int[][] newMatrix = new int[newSize][newSize];

        // Copy values, skipping the removed vertex row and column
        for (int i = 0, newI = 0; i < vertices; i++) {
            if (i == vertex) continue;
            for (int j = 0, newJ = 0; j < vertices; j++) {
                if (j == vertex) continue;
                newMatrix[newI][newJ] = adjMatrix[i][j];
                newJ++;
            }
            newI++;
        }

        this.vertices = newSize;
        this.adjMatrix = newMatrix;

        System.out.println("Vertex " + vertex + " removed.");
    }

    // Get the degree of vertex u (number of edges connected to u)
    public int getDegree(int u) {
        int degree = 0;
        if (u >= 0 && u < vertices) {
            for (int v = 0; v < vertices; v++) {
                if (adjMatrix[u][v] == 1) {
                    degree++;
                }
            }
        }
        return degree;
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
        AddRemoveMatrixVertices graph = new AddRemoveMatrixVertices(3); // Start with 3 vertices

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

