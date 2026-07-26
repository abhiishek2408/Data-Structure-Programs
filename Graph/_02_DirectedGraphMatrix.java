package Graph;

public class _02_DirectedGraphMatrix {

    public static void main(String[] args) {

        int vertices = 4;

        int[][] graph = new int[vertices][vertices];

        // Directed edges
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[2][3] = 1;

        // Print matrix
        for (int i = 0; i < vertices; i++) {

            for (int j = 0; j < vertices; j++) {

                System.out.print(graph[i][j] + " ");
            }

            System.out.println();
        }
    }
}
