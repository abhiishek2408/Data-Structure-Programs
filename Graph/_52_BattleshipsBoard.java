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

public class _52_BattleshipsBoard {

    static void bfs(char[][] board,
                    boolean[][] visited,
                    int row,
                    int col) {

        int rows = board.length;
        int cols = board[0].length;

        Queue<Pair> queue =
            new LinkedList<>();

        queue.add(new Pair(row, col));

        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            int r = current.row;
            int c = current.col;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    board[nr][nc] == 'X' &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    queue.add(
                        new Pair(nr, nc)
                    );
                }
            }
        }
    }

    static int countBattleships(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited =
            new boolean[rows][cols];

        int count = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'X' &&
                    !visited[i][j]) {

                    bfs(board, visited, i, j);

                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X','.','.','X'},
            {'.','.','.','X'},
            {'.','.','.','X'}
        };

        System.out.println(
            countBattleships(board)
        );
    }
}



/*Pattern Recognition

If question says:

islands
ships
groups
clusters
connected cells

Think:

Connected Components */
