// CheckSquareFormed.java
// Given 4 points in the plane, check if they form a square.

import java.util.HashSet;

public class CheckSquareFormed {
    public boolean isSquare(int[][] points) {
        if (points.length != 4) return false;
        HashSet<Integer> dists = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int dist = getDist(points[i], points[j]);
                if (dist == 0) return false; // overlapping points
                dists.add(dist);
            }
        }
        // For a square, there should be exactly 2 distinct distances:
        // 4 equal sides and 2 equal diagonals
        return dists.size() == 2;
    }

    private int getDist(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    // Example usage
    public static void main(String[] args) {
        CheckSquareFormed csf = new CheckSquareFormed();
        int[][] square = { {0,0}, {1,1}, {1,0}, {0,1} };
        int[][] notSquare = { {0,0}, {2,1}, {1,0}, {0,1} };
        System.out.println(csf.isSquare(square)); // Output: true
        System.out.println(csf.isSquare(notSquare)); // Output: false
    }
}
