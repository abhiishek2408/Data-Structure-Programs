package Graph;

import java.util.Scanner;

public class FindDegreeUnDirected {

    private int[][] adjMatrix;
    private int vertices;

    public FindDegreeUnDirected(int vertices) {
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

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        FindDegreeUnDirected graph = new FindDegreeUnDirected(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (format: src dest):");
        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        graph.printGraph();

        // Get the degree of a vertex
        System.out.print("Enter a vertex to find its degree: ");
        int u = scanner.nextInt();

        System.out.println("Degree of " + u + ": " + graph.getDegree(u));

        scanner.close();
    }
}

