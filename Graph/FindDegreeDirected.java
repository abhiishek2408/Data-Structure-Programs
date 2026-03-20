package Graph;

import java.util.Scanner;

public class FindDegreeDirected {

    private int[][] adjMatrix;
    private int vertices;

    public FindDegreeDirected(int vertices) {
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

    // Get out-degree of vertex u (edges going out)
    public int getOutDegree(int u) {
        int outDegree = 0;
        if (u >= 0 && u < vertices) {
            for (int v = 0; v < vertices; v++) {
                if (adjMatrix[u][v] == 1) {
                    outDegree++;
                }
            }
        }
        return outDegree;
    }

    // Get in-degree of vertex u (edges coming in)
    public int getInDegree(int u) {
        int inDegree = 0;
        if (u >= 0 && u < vertices) {
            for (int v = 0; v < vertices; v++) {
                if (adjMatrix[v][u] == 1) {
                    inDegree++;
                }
            }
        }
        return inDegree;
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
        FindDegreeDirected graph = new FindDegreeDirected(vertices);

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
        System.out.print("Enter a vertex to find its in-degree and out-degree: ");
        int u = scanner.nextInt();

        System.out.println("Out-degree of " + u + ": " + graph.getOutDegree(u));
        System.out.println("In-degree of " + u + ": " + graph.getInDegree(u));

        scanner.close();
    }
}

