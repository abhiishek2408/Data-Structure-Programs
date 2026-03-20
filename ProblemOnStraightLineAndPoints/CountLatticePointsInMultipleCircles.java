import java.util.HashSet;
import java.util.Set;

public class CountLatticePointsInMultipleCircles {
    public static void main(String[] args) {
        // Example usage
        int[][] circles = {
            {2, 2, 1},
            {3, 4, 1}
        };
        System.out.println("Lattice points inside at least one circle: " + countLatticePoints(circles));
    }

    public static int countLatticePoints(int[][] circles) {
        Set<String> points = new HashSet<>();
        for (int[] circle : circles) {
            int cx = circle[0], cy = circle[1], r = circle[2];
            int r2 = r * r;
            for (int x = cx - r; x <= cx + r; x++) {
                for (int y = cy - r; y <= cy + r; y++) {
                    int dx = x - cx;
                    int dy = y - cy;
                    if (dx * dx + dy * dy <= r2) {
                        points.add(x + "," + y);
                    }
                }
            }
        }
        return points.size();
    }
}
