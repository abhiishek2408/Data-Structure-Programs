package Graph;

import java.util.*;

class Pair {

    int row;
    int col;

    Pair(int row, int col) {

        this.row = row;
        this.col = col;
    }
}

public class _51_WallsAndGates {

    static void wallsAndGates(int[][] rooms) {

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<Pair> queue =
            new LinkedList<>();

        // Add all gates
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (rooms[i][j] == 0) {

                    queue.add(
                        new Pair(i, j)
                    );
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            int r = current.row;
            int c = current.col;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                // Check valid empty room
                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    rooms[nr][nc] == Integer.MAX_VALUE) {

                    rooms[nr][nc] =
                        rooms[r][c] + 1;

                    queue.add(
                        new Pair(nr, nc)
                    );
                }
            }
        }
    }

    public static void main(String[] args) {

        int INF = Integer.MAX_VALUE;

        int[][] rooms = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };

        wallsAndGates(rooms);

        // Print answer
        for (int[] row : rooms) {

            for (int val : row) {

                System.out.print(val + " ");
            }

            System.out.println();
        }
    }
}
