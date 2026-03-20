// ClosestPairOfPoints.java
// Given a set of points, find the smallest distance between any two points (brute force O(n^2)).

public class ClosestPairOfPoints {
    public double closestPair(int[][] points) {
        int n = points.length;
        if (n < 2) return 0;
        double minDist = Double.MAX_VALUE;
        int[] p1 = null, p2 = null;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        if (p1 != null && p2 != null) {
            System.out.println("Closest pair: [" + p1[0] + ", " + p1[1] + "] and [" + p2[0] + ", " + p2[1] + "]");
        }
        return minDist;
    }

    private double distance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Example usage
    public static void main(String[] args) {
        ClosestPairOfPoints cpp = new ClosestPairOfPoints();
        int[][] points = { {0,0}, {1,1}, {2,2}, {2,0}, {2,4}, {3,3}, {4,2} };
        double minDist = cpp.closestPair(points);
        System.out.println("Minimum distance: " + minDist); // Output: 1.414...
    }
}
