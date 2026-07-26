package Graph;

public class _01_AdjacencyMatrix {

    public static void main(String[] args) {

        int vertices = 4;

        // Create matrix
        int[][] graph = new int[vertices][vertices];

        // Add edges
        graph[0][1] = 1;
        graph[1][0] = 1;

        graph[0][2] = 1;
        graph[2][0] = 1;

        graph[1][3] = 1;
        graph[3][1] = 1;

        graph[2][3] = 1;
        graph[3][2] = 1;

        // Print matrix
        System.out.println("Adjacency Matrix:");

        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                System.out.print(graph[i][j] + " ");
            }

            System.out.println();
        }
    }
}
