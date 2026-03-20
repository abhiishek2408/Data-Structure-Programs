package Graph;

import java.util.Scanner;

public class AddRemoveMatrixEdgeUndirected {
    private int[][] adjMatrix;
    private int vertices;

    public AddRemoveMatrixEdgeUndirected(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = 1;
            adjMatrix[dest][src] = 1; // Undirected graph
        } else {
            System.out.println("Invalid edge: (" + src + ", " + dest + ")");
        }
    }

    public void removeEdge(int src, int dest) {
        if (src >= 0 && src < vertices && dest >= 0 && dest < vertices) {
            adjMatrix[src][dest] = 0;
            adjMatrix[dest][src] = 0;
        } else {
            System.out.println("Invalid edge: (" + src + ", " + dest + ")");
        }
    }

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
        AddRemoveMatrixEdgeUndirected graph = new AddRemoveMatrixEdgeUndirected(vertices);

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

