package Graph;

import java.util.*;

public class _32_2_RottenOranges {

    public static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Step 1: Put all rotten oranges into queue
        // and count fresh oranges

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int time = 0;

        // BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] cell = queue.poll();

                int r = cell[0];
                int c = cell[1];

                // Check 4 directions
                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    // Valid fresh orange
                    if (nr >= 0 && nc >= 0 &&
                        nr < rows && nc < cols &&
                        grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;

                        queue.add(new int[]{nr, nc});

                        fresh--;
                    }
                }
            }

            time++;
        }

        // If fresh orange still left
        if (fresh > 0) {
            return -1;
        }

        return time;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        System.out.println(orangesRotting(grid));
    }
}
