// ValidSquare.java
// Given 4 points, check if they form a valid square (all sides equal, diagonals equal, no overlap).

import java.util.HashSet;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = {p1, p2, p3, p4};
        HashSet<Integer> dists = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                int dist = getDist(points[i], points[j]);
                if (dist == 0) return false; // overlapping points
                dists.add(dist);
            }
        }
        // For a valid square, there should be exactly 2 distinct distances:
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
        ValidSquare vs = new ValidSquare();
        int[] p1 = {0,0}, p2 = {1,1}, p3 = {1,0}, p4 = {0,1};
        int[] q1 = {0,0}, q2 = {2,1}, q3 = {1,0}, q4 = {0,1};
        System.out.println(vs.validSquare(p1, p2, p3, p4)); // Output: true
        System.out.println(vs.validSquare(q1, q2, q3, q4)); // Output: false
    }
}
