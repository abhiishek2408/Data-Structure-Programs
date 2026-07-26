package Graph;

public class _03_WeightedGraph {

    public static void main(String[] args) {

        int vertices = 4;

        int[][] graph = new int[vertices][vertices];

        // Add weighted edges
        graph[0][1] = 5;
        graph[1][0] = 5;

        graph[0][2] = 3;
        graph[2][0] = 3;

        graph[1][3] = 2;
        graph[3][1] = 2;

        // Print matrix
        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                System.out.print(graph[i][j] + " ");
            }

            System.out.println();
        }
    }
}
