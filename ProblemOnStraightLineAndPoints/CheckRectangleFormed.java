// CheckRectangleFormed.java
// Given 4 points in the plane, check if they form a rectangle.

import java.util.Arrays;

public class CheckRectangleFormed {
    public boolean isRectangle(int[][] points) {
        if (points.length != 4) return false;
        int[] dists = new int[6];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                dists[idx++] = getDist(points[i], points[j]);
            }
        }
        Arrays.sort(dists);
        // For a rectangle:
        // - 2 diagonals (longest, equal)
        // - 4 sides (shorter, equal)
        // - Sides > 0, diagonals > sides
        return dists[0] > 0 &&
               dists[0] == dists[1] &&
               dists[1] == dists[2] &&
               dists[2] == dists[3] &&
               dists[4] == dists[5] &&
               dists[3] < dists[4];
    }

    private int getDist(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    // Example usage
    public static void main(String[] args) {
        CheckRectangleFormed crf = new CheckRectangleFormed();
        int[][] rectangle = { {0,0}, {2,0}, {2,1}, {0,1} };
        int[][] notRectangle = { {0,0}, {1,1}, {1,0}, {0,2} };
        System.out.println(crf.isRectangle(rectangle)); // Output: true
        System.out.println(crf.isRectangle(notRectangle)); // Output: false
    }
}
